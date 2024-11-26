package org.example.restaurantmenu;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public final class RestaurantMenuModel {
    @RequiredArgsConstructor
    static class MenuItem {
        @Getter
        protected final String name;
        @Getter
        protected final Double cost;

        @Override
        public String toString() {
            return name + " - " + cost + " руб.";
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;

            final MenuItem other = (MenuItem) obj;
            return name.equals(other.getName());
        }
    }

    final static class OrderItem extends MenuItem {
        @Getter
        @Setter
        private Integer quantity;

        public OrderItem(final String name, final Double cost, final Integer quantity) {
            super(name, cost);
            this.quantity = quantity;
        }

        public OrderItem(final MenuItem item, final Integer quantity) {
            super(item.getName(), item.getCost());
            this.quantity = quantity;
        }

        public void addQuantity(final Integer quantity) {
            this.quantity = this.quantity + quantity;
        }

        @Override
        public String toString() {
            return name + ", " + quantity + " шт. - " + cost * quantity + " руб.";
        }
    }

    @Getter
    private final ListProperty<MenuItem> menu = new SimpleListProperty<>(FXCollections.observableArrayList(
        new MenuItem("Капричиоза", 700.0),
        new MenuItem("Маргарита", 550.0),
        new MenuItem("Вегетарианская", 735.0),
        new MenuItem("Пепперони", 625.0),
        new MenuItem("Гавайская", 575.0),
        new MenuItem("Четыре сыра", 710.0),
        new MenuItem("Мексиканская", 850.0),
        new MenuItem("Кальцоне", 675.0),
        new MenuItem("Неаполитанская", 700.0),
        new MenuItem("Буфалина", 795.0)
    ));

    @Getter
    private final ListProperty<OrderItem> order = new SimpleListProperty<>(FXCollections.observableArrayList());

    @Getter
    private final Integer maxPortionsForItem = 100;

    public final void addItemToOrder(final OrderItem item) {
        final Integer itemIndex = order.indexOf(item);
        if (itemIndex == -1) {
            order.add(item);
            return;
        }
        item.setQuantity(Math.min(item.getQuantity() + order.get(itemIndex).getQuantity(), maxPortionsForItem));
        order.set(itemIndex, item);
    }

    public final void removeItemFromOrder(final OrderItem item) {
        final Integer itemIndex = order.indexOf(item);
        if(itemIndex == -1) {
            return;
        }
        if(item.getQuantity() >= order.get(itemIndex).getQuantity()) 
        {
            order.remove(order.get(itemIndex));
            return;
        }
        final Integer newQuantity = order.get(itemIndex).getQuantity() - item.getQuantity();
        item.setQuantity(newQuantity);
        order.set(itemIndex, item);
    }

    public final String order() {
        if (order.isEmpty()) {
            return "Ваш заказ пуст.\n";
        }
        final StringBuilder result = new StringBuilder();
        Double sum = 0.0;
        for (OrderItem item : order) {
            result.append(item);
            result.append("\n");
            sum += item.getQuantity() * item.getCost();
        }
        result.append("Итого: ");
        result.append(sum);
        result.append(" руб.\n");
        return result.toString();
    }
}
