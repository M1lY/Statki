package Statki;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    ArrayList<String> lId = new ArrayList<>(20);
    String[] aId = new String[20];
    int wS = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Statki");

        primaryStage.setScene(new Scene(root, 675, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        root.requestFocus();
/*        ResourceManager.reset("1.save");
        ResourceManager.reset("2.save");
        ResourceManager.reset("player");*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}