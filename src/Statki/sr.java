package Statki;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class sr {
    String[] aId = new String[20];
    int wS = 0;

    public void save(String sId){
        aId[wS] = sId;
        String id = aId[wS];
        System.out.println(id);
        wS++;
    }

    public void set() throws IOException {
        for (int i=0; i<20; i++){
            String id = aId[i];
            System.out.println(id);

            Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
            JFXButton button = (JFXButton) root.lookup("#" + id);
            button.setStyle("-fx-background-color: black");
        }
    }
}
