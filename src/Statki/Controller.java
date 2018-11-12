package Statki;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Window;

import java.util.Arrays;
import java.util.List;

public class Controller {
    ConnectionParams params=new ConnectionParams();
    private boolean isHost;
    public Text tError;
    String[] tab = new String[20];
    char[] alphabet = "ABCDEFGHIJ".toCharArray();
    int i1 = 4;
    int i2 = 3;
    int i3 = 2;
    int i4 = 1;
    int letter;
    int number;
    int letterM;
    int iM = 1;
    char direction = 'V';
    public Button m1;
    public Button m2;
    public Button m3;
    public Button m4;
    //public JFXButton sTurn;
    int wS = 0;
    Main main = new Main();
    String[] aId = new String[20];
    int wSs = 0;
    int player=1;

    public void btnHover(MouseEvent mouseEvent){
        switch (iM){
            case 1:
                if(i1 > 0){
                    doHover(mouseEvent, 1, 10, 10);
                }else if (i1 == 0){
                    iM = 2;
                }
                break;
            case 2:
                if(i2 > 0){
                    doHover(mouseEvent, 2, 8, 9);
                }else if (i2 == 0){
                    iM = 3;
                }
                break;
            case 3:
                if(i3 > 0){
                    doHover(mouseEvent, 3, 7, 8);
                }else if (i3 == 0){
                    iM = 4;
                }
                break;
            case 4:
                if(i4 > 0){
                    doHover(mouseEvent, 4, 6, 7);
                }
                break;
        }
    }

    public void doHover(MouseEvent mouseEvent, int x, int stopV, int stopH) {
        JFXButton btn = (JFXButton) mouseEvent.getSource();
        splitIdChar(btn.getId());
        if (direction == 'V'){
            if(letterM > stopV){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: grey");
                    }
                    stopV++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: grey");
                    }
                    letterM++;
                }
            }
        }else if (direction == 'H'){
            if(number > stopH){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: grey");
                    }
                    stopH++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: grey");
                    }
                    number++;
                }
            }
        }
    }

    public void btnExit(MouseEvent mouseEvent){
        switch (iM){
            case 1:
                doExit(mouseEvent, 1, 10, 10);
                break;
            case 2:
                doExit(mouseEvent, 2, 8, 9);
                break;
            case 3:
                doExit(mouseEvent, 3,7, 8);
                break;
            case 4:
                doExit(mouseEvent, 4,6, 7);
                break;
        }
    }

    public void doExit(MouseEvent mouseEvent, int x , int stopV, int stopH){
        JFXButton btn = (JFXButton) mouseEvent.getSource();
        splitIdChar(btn.getId());
        if(direction == 'V'){
            if(letterM > stopV){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: #497496");
                    }

                    stopV++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: #497496");
                    }
                    letterM++;
                }
            }
        }else if(direction == 'H'){
            if(number > stopH){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: #497496");
                    }
                    stopH++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    JFXButton button = (JFXButton) root.lookup("#" + id);
                    if(button.getStyle() !="-fx-background-color: black"){
                        button.setStyle("-fx-background-color: #497496");
                    }
                    number++;
                }
            }
        }
    }

    public void btnSet(MouseEvent event) {
        switch (iM){
            case 1:
                if(i1>0 && validator(event, 1, 10, 10)) {
                    doSet(event, 1, 10, 10);
                    i1--;
                    m1.setText("Jendomasztowce (pozostało: " + i1 + ")");
                }else if(i1<=0){
                    setError("Nie masz już więcej statków");
                }else{
                    setError("W tym miejscu nie możesz ustawić statku");
                }
                break;
            case 2:
                if(i2>0 && validator(event, 2, 8, 9)){
                    doSet(event, 2, 8, 9);
                    i2--;
                    m2.setText("Dwumasztowce (pozostało: " + i2 + ")");
                }else if(i2<=0){
                    setError("Nie masz już więcej statków");
                }else{
                    setError("W tym miejscu nie możesz ustawić statku");
                }
                break;
            case 3:
                if(i3>0 && validator(event, 3, 7, 8)) {
                    doSet(event, 3, 7, 8);
                    i3--;
                    m3.setText("Trzymasztowce (pozostało: " + i3 + ")");
                }else if(i3<=0){
                    setError("Nie masz już więcej statków");
                }else{
                    setError("W tym miejscu nie możesz ustawić statku");
                }
                break;
            case 4:
                if(i4>0 && validator(event, 4, 6, 7)) {
                    doSet(event, 4, 6, 7);
                    i4--;
                    m4.setText("Czteromasztowce (pozostało: " + i4 + ")");
                }else if(i4<=0){
                    setError("Nie masz już więcej statków");
                }else{
                    setError("W tym miejscu nie możesz ustawić statku");
                }
                break;
        }
    }

    private void setError(String s){
        tError.setText(s);
        new Thread(() -> {
            try {
                Thread.sleep(1500);
                tError.setOpacity(0.75);
                Thread.sleep(100);
                tError.setOpacity(0.50);
                Thread.sleep(100);
                tError.setOpacity(0.25);
                Thread.sleep(100);
                tError.setText("");
                tError.setOpacity(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void doSet(MouseEvent event, int x, int stopV, int stopH){
        JFXButton btn = (JFXButton) event.getSource();
        String bId = btn.getId();
        splitIdChar(bId);
        if (direction == 'V'){
            if(letterM > stopV){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    stopV++;
                    tab[wS] = String.valueOf(stopV+""+number);
                    wS++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    letterM++;
                    tab[wS] = String.valueOf(letterM+""+number);
                    wS++;
                }
            }
        }else if (direction == 'H'){
            if(number > stopH){
                for (int i = 0 ; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    save(id);
                    setBlack(event, id);
                    stopH++;
                    System.out.println(letter+""+stopH);
                    tab[wS] = String.valueOf(letter+""+stopH);
                    wS++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    tab[wS] = String.valueOf(letter+""+number);
                    number++;
                    wS++;
                }
            }
        }
    }

    public void setBlack(MouseEvent event, String id){
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        Scene root = theStage.getScene();
        JFXButton button = (JFXButton) root.lookup("#" + id);
        button.setStyle("-fx-background-color: black");
    }

    public void splitIdChar(String Id){
        char a = Id.charAt(0);
        for (int i=0; i<10; i++){
            if(alphabet[i] == a){
                i++;
                letter = i;
                letterM = letter-1;
            }
        }
        number = Integer.parseInt(Id.substring(1));
        return;
    }

    public void mClick(ActionEvent event){
        Button btn = (Button) event.getSource();
        switch (btn.getId()){
            case "m1":
                iM = 1;
                break;
            case "m2":
                iM = 2;
                break;
            case "m3":
                iM = 3;
                break;
            case "m4":
                iM = 4;
                break;
        }
    }

    public void switchingDirection(ActionEvent event){
        Button btn = (Button) event.getSource();
        switch (btn.getId()){
            case "V":
                direction = 'V';
                break;
            case "H":
                direction = 'H';
                break;
        }
    }

    public boolean validator(MouseEvent event, int x, int stopV, int stopH){
        JFXButton btn = (JFXButton) event.getSource();
        String bId = btn.getId();
        splitIdChar(bId);
        if (direction == 'V'){
            if(letterM > stopV){
                for (int i = 0 ; i < x; i++){
                    List<String> list = Arrays.asList(tab);
                    stopV++;
                    if (valP(stopV, number, list)){
                        return false;
                    }
                }
            }else{
                for (int i = 0; i < x; i++){
                    List<String> list = Arrays.asList(tab);
                    letterM++;
                    if (valP(letterM, number, list)){
                        return false;
                    }
                }
            }
        }else if (direction == 'H'){
            if(number > stopH){
                for (int i = 0; i < x; i++){
                    List<String> list = Arrays.asList(tab);
                    stopH++;
                    if (valP(letter, stopH, list)){
                        return false;
                    }
                }
            }else{
                for (int i = 0; i < x; i++){
                    List<String> list = Arrays.asList(tab);
                    if (valP(letter, number, list)){
                        return false;
                    }
                    number++;
                }
            }
        }
        return true;
    }

    public boolean valP(int a, int b, List<String> list){
        for (int p=0; p<19; p++){
            if (list.contains(String.valueOf(a+""+b)) || list.contains(String.valueOf(a+""+(b+1))) || list.contains(String.valueOf(a+""+(b-1))) || list.contains(String.valueOf((a+1) +""+ b)) || list.contains(String.valueOf((a+1) +""+ (b+1))) || list.contains(String.valueOf((a+1) +""+ (b-1))) || list.contains(String.valueOf((a-1) +""+ b)) || list.contains(String.valueOf((a-1) +""+ (b+1))) || list.contains(String.valueOf((a-1) +""+ (b-1)))){
                return true;
            }
        }
        return false;
    }

    public void sTurn(ActionEvent event){


    }

    public void save(String sId){
        aId[wSs] = sId;
        String id = aId[wSs];
        //System.out.println(id);
        wSs++;
    }

}