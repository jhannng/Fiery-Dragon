package org.fierydragon.fierydragon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class that represent the Game in FieryDragon application.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class FieryDragonApplication extends Application {
    /**
     * This method will start the game
     * @param stage top level java fx container that is constructed by the platform
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FieryDragonApplication.class.getResource("MainMenuScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 815, 500);
        stage.setTitle("Fiery Dragon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method will launch the application
     * @param args The terminal arguments
     */
    public static void main(String[] args) {
        launch();
    }
}