package Statki;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerBTS {
    Main main = new Main();
    String[] aId = new String[20];
    int wS = 0;
    sr sr = new sr();

    public void save(String sId) {
        /*lId.add(sId);
        System.out.println(lId.get(0));
        System.out.println("dsa"+sId);*/
        aId[wS] = sId;
        String id = aId[wS];
        System.out.println(id);
        wS++;
    }

    public void clickAW(MouseEvent mouseEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        Scene BTS_scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(BTS_scene);
        window.show();
        root.requestFocus();
        /*for (int i=0; i<20; i++){
            String id = aId[i];
            System.out.println(id);
            JFXButton button = (JFXButton) root.lookup("#" + id);
            button.setStyle("-fx-background-color: black");
        }*/
        set();
    }

    public void set() throws IOException {

        for (int i = 0; i < 20; i++) {
            String id = aId[i];
            System.out.println(id);

            Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
            JFXButton button = (JFXButton) root.lookup("#" + id);
            button.setStyle("-fx-background-color: black");
        }

    }
}
