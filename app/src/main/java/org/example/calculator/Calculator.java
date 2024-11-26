package org.example.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Calculator {
    public final void run() {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Calculator.fxml"));
            final Scene scene = new Scene(loader.load());
            final Stage stage = new Stage();
            stage.setTitle("Calculator");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
