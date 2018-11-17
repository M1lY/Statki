package Statki;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {
    public Text tError;
    private String[] tab = new String[20];
    private char[] alphabet = "ABCDEFGHIJ".toCharArray();
    private int i1 = 4;
    private int i2 = 3;
    private int i3 = 2;
    private int i4 = 1;
    private int letter;
    private int number;
    private int letterM;
    private int iM = 1;
    private char direction = 'V';
    public Button m1;
    public Button m2;
    public Button m3;
    public Button m4;
    private int wS = 0;
    private String[] aId = new String[20];
    private int wSs = 0;
    private static int player = 1;
    private Saver saver = new Saver();
    private static boolean block1=false;
    private static boolean block2=false;

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

    private void doHover(MouseEvent mouseEvent, int x, int stopV, int stopH) {
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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

    private void doExit(MouseEvent mouseEvent, int x, int stopV, int stopH){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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
                    if(!button.getStyle().equals("-fx-background-color: black")){
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

    private void doSet(MouseEvent event, int x, int stopV, int stopH){
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
                    tab[wS] = String.valueOf(letter+""+stopH);
                    System.out.println("do set "+letter);
                    System.out.println("do set "+stopH);
                    wS++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    tab[wS] = String.valueOf(letter+""+number);
                    System.out.println("do set "+letter);
                    System.out.println("do set "+number);
                    number++;
                    wS++;
                }
            }
        }
    }

    private void setError(String s){
        tError.setText(s);
        tError.setOpacity(1);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), tError);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                ft.play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void setBlack(MouseEvent event, String id){
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        Scene root = theStage.getScene();
        JFXButton button = (JFXButton) root.lookup("#" + id);
        button.setStyle("-fx-background-color: black");
    }

    private void splitIdChar(String Id){
        char a = Id.charAt(0);
        for (int i=0; i<10; i++){
            if(alphabet[i] == a){
                i++;
                letter = i;
                letterM = letter-1;
            }
        }
        number = Integer.parseInt(Id.substring(1));
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

    private boolean validator(MouseEvent event, int x, int stopV, int stopH){
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
                    System.out.println("valid number>stopH letter:"+letter);
                    System.out.println("valid number>stopH stopH:"+stopH);
                    if (valP(letter, stopH, list)){
                        return false;
                    }
                    stopH++;
                }
            }else{
                for (int i = 0; i < x; i++){
                    List<String> list = Arrays.asList(tab);
                    System.out.println("valid number<=stopH letter:"+letter);
                    System.out.println("valid number<=stopH number:"+number);
                    if (valP(letter, number, list)){
                        return false;
                    }
                    number++;
                }
            }
        }
        return true;
    }

    private boolean valP(int a, int b, List<String> list){
        for (int p=0; p<19; p++){
            if (list.contains(String.valueOf(a+""+b)) || list.contains(String.valueOf(a+""+(b+1))) || list.contains(String.valueOf(a+""+(b-1))) || list.contains(String.valueOf((a+1) +""+ b)) || list.contains(String.valueOf((a+1) +""+ (b+1))) || list.contains(String.valueOf((a+1) +""+ (b-1))) || list.contains(String.valueOf((a-1) +""+ b)) || list.contains(String.valueOf((a-1) +""+ (b+1))) || list.contains(String.valueOf((a-1) +""+ (b-1)))){
                return true;
            }
        }
        return false;
    }

    private void save(String sId){
        aId[wSs] = sId;
        System.out.println(sId);
        wSs++;
    }

    public void btnPC(ActionEvent event){
        if(block1&&block2){
            ((Node)event.getSource()).getScene().getWindow().hide();
            if(player==1) player=2;
            else if(player==2) player=1;
            PC(event);
            return;
        }
        if(i1!=0||i2!=0||i3!=0||i4!=0){
            setError("Aby oddac ture najpierw postaw wszystkie dostepne statki na plansz\u0119");
            return;
        }
        ((Node)event.getSource()).getScene().getWindow().hide();

        if(player==1) block1=true;
        if(player==2) block2=true;

        saver.setId(aId,player);
        System.out.println("zapis dla"+player);
        if(player==1) player=2;
        else if(player==2) player=1;

        PC(event);
    }

    private void PC(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BTS.fxml"));
            Scene BTS_scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(BTS_scene);
            window.show();
            root.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickAW(MouseEvent mouseEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();

        Scene BTS_scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(BTS_scene);
        root.requestFocus();

        Map<String, Object> namespace = loader.getNamespace();
        GridPane gridPane = (GridPane) namespace.get("GP");
        GridPane gridPaneD = (GridPane) namespace.get("GPd");
        load(saver.getId(player),root);
        if((player==1&& block1)||(player==2&& block2)){
            gridPane.setDisable(true);
            gridPaneD.setDisable(false);
        }
        System.out.println("wczytanie dla"+player);

        window.show();
    }

    private void load(String[] aId, Parent root){
        for(int i=0; i<=19; i++){
            String id = aId[i];
//            System.out.println("id: "+id);
            if(aId[i]!=null) {
                JFXButton button = (JFXButton) root.lookup("#" + id);
                button.setStyle("-fx-background-color: black");
            }
        }
    }
}