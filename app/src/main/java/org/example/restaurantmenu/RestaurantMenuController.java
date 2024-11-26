package org.example.restaurantmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public final class RestaurantMenuController {
    @FXML
    ListView<RestaurantMenuModel.MenuItem> menuList;
    @FXML
    ListView<RestaurantMenuModel.OrderItem> orderList;
    @FXML
    Spinner<Integer> addQuantitySpinner;
    @FXML
    Spinner<Integer> removeQuantitySpinner;
    @FXML
    Button addButton;
    @FXML
    Button removeButton;
    @FXML
    Button orderButton;

    private final RestaurantMenuModel model = new RestaurantMenuModel();

    private final void addItemToOrder() {
        model.addItemToOrder(new RestaurantMenuModel.OrderItem(menuList.getSelectionModel().getSelectedItem(), addQuantitySpinner.getValue()));
        orderList.getSelectionModel().select(model.getOrder().getLast());
    }

    private final void removeItemFromOrder() {
        final RestaurantMenuModel.MenuItem item = orderList.getSelectionModel().getSelectedItem();
        if (item != null) model.removeItemFromOrder(new RestaurantMenuModel.OrderItem(item, removeQuantitySpinner.getValue()));
        if (orderList.getSelectionModel().getSelectedItem() == null) orderList.getSelectionModel().select(0);
    }

    private final void order() {
        Alert resultFlag = new Alert(AlertType.INFORMATION);
        resultFlag.setTitle("Order");
        resultFlag.setHeaderText(null);
        resultFlag.setContentText(model.order());
        resultFlag.showAndWait();
    }

    @FXML
    public final void initialize() {
        menuList.setItems(model.getMenu().getValue());
        orderList.setItems(model.getOrder().getValue());
        menuList.getSelectionModel().select(0);
        addQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, model.getMaxPortionsForItem(), 1));
        removeQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, model.getMaxPortionsForItem(), 1));
        addButton.setOnAction(e -> addItemToOrder());
        removeButton.setOnAction(e -> removeItemFromOrder());
        orderButton.setOnAction(e -> order());

    }
}
