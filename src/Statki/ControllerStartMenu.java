package Statki;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerStartMenu {
    ConnectionParams params = new ConnectionParams();
    initConnection initConnection=new initConnection();

    public void create(ActionEvent event) throws IOException {
        params.setHost(true);
        initConnection.init(params);

        ((Node)event.getSource()).getScene().getWindow().hide();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Statki - host");
        primaryStage.setScene(new Scene(root, 675, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        root.requestFocus();
    }

    public void join(ActionEvent event) throws IOException {
        params.setHost(false);
        initConnection.init(params);

        ((Node)event.getSource()).getScene().getWindow().hide();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Statki - klient");
        primaryStage.setScene(new Scene(root, 675, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        root.requestFocus();
    }
}
