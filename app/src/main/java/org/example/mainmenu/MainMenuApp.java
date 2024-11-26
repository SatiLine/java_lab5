package org.example.mainmenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class MainMenuApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
            final Scene scene = new Scene(loader.load());
            primaryStage.setTitle("MainMenu");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }   
}