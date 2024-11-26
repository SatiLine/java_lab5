package org.example.wordshifter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class WordShifter {
    public final void run() {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/WordShifter.fxml"));
            final Scene scene = new Scene(loader.load());
            final Stage stage = new Stage();
            stage.setTitle("Word shifter");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
