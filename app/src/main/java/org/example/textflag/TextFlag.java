package org.example.textflag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TextFlag {
    public final void run() {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextFlag.fxml"));
            final Scene scene = new Scene(loader.load());
            final Stage stage = new Stage();
            stage.setTitle("TextFlag");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
