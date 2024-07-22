package org.example.fierydragon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameMainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(GameMainMenuController.class.getResource("GameMainMenu.fxml"));
         Scene scene = new Scene(fxmlLoader.load(), 800, 500);
         stage.setTitle("Fiery Dragon Game Board");
         stage.setScene(scene);
         stage.setResizable(false);
         stage.show();
     }

    /** public static void main(String[] args) {
        launch();
    } **/
}
