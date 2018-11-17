package Statki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Statki/GUI.fxml"));
        primaryStage.setTitle("Statki");

        primaryStage.setScene(new Scene(root, 678, 509));
        primaryStage.setResizable(false);
        primaryStage.show();
//        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}