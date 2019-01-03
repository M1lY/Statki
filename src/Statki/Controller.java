package Statki;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
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
    private List<String> sId = new ArrayList<>();
    private int wSs = 0;
    private static int player = 1;
    private Saver saver = new Saver();
    private static boolean block1 = false;
    private static boolean block2 = false;
    private List<String> temp = new ArrayList<>();
    private List<String> temp2 = new ArrayList<>();
    private boolean ifHaveMove = true;
    private static Stage windowSave = new Stage();

    public void btnHover(MouseEvent mouseEvent) {
        switch (iM) {
            case 1:
                if (i1 > 0) {
                    doHover(mouseEvent, 1, 10, 10);
                } else if (i1 == 0) {
                    if (i2 != 0) iM = 2;
                    else if (i3 != 0) iM = 3;
                    else if (i4 != 0) iM = 4;
                }
                break;
            case 2:
                if (i2 > 0) {
                    doHover(mouseEvent, 2, 8, 9);
                } else if (i2 == 0) {
                    if (i1 != 0) iM = 1;
                    else if (i3 != 0) iM = 3;
                    else if (i4 != 0) iM = 4;
                }
                break;
            case 3:
                if (i3 > 0) {
                    doHover(mouseEvent, 3, 7, 8);
                } else if (i3 == 0) {
                    if (i1 != 0) iM = 1;
                    else if (i2 != 0) iM = 2;
                    else if (i4 != 0) iM = 4;
                }
                break;
            case 4:
                if (i4 > 0) {
                    doHover(mouseEvent, 4, 6, 7);
                } else if (i4 == 0) {
                    if (i1 != 0) iM = 0;
                    else if (i2 != 0) iM = 2;
                    else if (i3 != 0) iM = 3;
                }
                break;
        }
    }

    private void doHover(MouseEvent mouseEvent, int x, int stopV, int stopH) {
        Button btn = (Button) mouseEvent.getSource();
        splitIdChar(btn.getId());
        if (direction == 'V') {
            if (letterM > stopV) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: grey");
                    }
                    stopV++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: grey");
                    }
                    letterM++;
                }
            }
        } else if (direction == 'H') {
            if (number > stopH) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: grey");
                    }
                    stopH++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: grey");
                    }
                    number++;
                }
            }
        }
    }

    public void btnExit(MouseEvent mouseEvent) {
        switch (iM) {
            case 1:
                doExit(mouseEvent, 1, 10, 10);
                break;
            case 2:
                doExit(mouseEvent, 2, 8, 9);
                break;
            case 3:
                doExit(mouseEvent, 3, 7, 8);
                break;
            case 4:
                doExit(mouseEvent, 4, 6, 7);
                break;
        }
    }

    private void doExit(MouseEvent mouseEvent, int x, int stopV, int stopH) {
        Button btn = (Button) mouseEvent.getSource();
        splitIdChar(btn.getId());
        if (direction == 'V') {
            if (letterM > stopV) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: #497496");
                    }

                    stopV++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: #497496");
                    }
                    letterM++;
                }
            }
        } else if (direction == 'H') {
            if (number > stopH) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: #497496");
                    }
                    stopH++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    Node source = (Node) mouseEvent.getSource();
                    Window theStage = source.getScene().getWindow();
                    Scene root = theStage.getScene();
                    Button button = (Button) root.lookup("#" + id);
                    if (!button.getStyle().equals("-fx-background-color: black")) {
                        button.setStyle("-fx-background-color: #497496");
                    }
                    number++;
                }
            }
        }
    }

    public void btnSet(MouseEvent event) {
        switch (iM) {
            case 1:
                if (i1 > 0 && validator(event, 1, 10, 10)) {
                    doSet(event, 1, 10, 10);
                    i1--;
                    m1.setText("Jednomasztowce (pozosta\u0142o: " + i1 + ")");
                } else if (i1 <= 0) {
                    setError("Nie masz ju\u017C wi\u0119cej statk\u00F3w");
                } else {
                    setError("W tym miejscu nie mo\u017Cesz ustawi\u0107 statku");
                }
                break;
            case 2:
                if (i2 > 0 && validator(event, 2, 8, 9)) {
                    doSet(event, 2, 8, 9);
                    i2--;
                    m2.setText("Dwumasztowce (pozosta\u0142o: " + i2 + ")");
                } else if (i2 <= 0) {
                    setError("Nie masz ju\u017C wi\u0119cej statk\u00F3w");
                } else {
                    setError("W tym miejscu nie mo\u017Cesz ustawi\u0107 statku");
                }
                break;
            case 3:
                if (i3 > 0 && validator(event, 3, 7, 8)) {
                    doSet(event, 3, 7, 8);
                    i3--;
                    m3.setText("Trzymasztowce (pozosta\u0142o: " + i3 + ")");
                } else if (i3 <= 0) {
                    setError("Nie masz ju\u017C wi\u0119cej statk\u00F3w");
                } else {
                    setError("W tym miejscu nie mo\u017Cesz ustawi\u0107 statku");
                }
                break;
            case 4:
                if (i4 > 0 && validator(event, 4, 6, 7)) {
                    doSet(event, 4, 6, 7);
                    i4--;
                    m4.setText("Czteromasztowce (pozosta\u0142o: " + i4 + ")");
                } else if (i4 <= 0) {
                    setError("Nie masz ju\u017C wi\u0119cej statk\u00F3w");
                } else {
                    setError("W tym miejscu nie mo\u017Cesz ustawi\u0107 statku");
                }
                break;
        }
    }

    private void doSet(MouseEvent event, int x, int stopV, int stopH) {
        Button btn = (Button) event.getSource();
        String bId = btn.getId();
        splitIdChar(bId);
        if (direction == 'V') {
            if (letterM > stopV) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[stopV]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    stopV++;
                    tab[wS] = stopV + "" + number;
                    wS++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    letterM++;
                    tab[wS] = letterM + "" + number;
                    wS++;
                }
            }
        } else if (direction == 'H') {
            if (number > stopH) {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + stopH;
                    save(id);
                    setBlack(event, id);
                    stopH++;
                    tab[wS] = letter + "" + stopH;
                    wS++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    String let = String.valueOf(alphabet[letterM]);
                    String id = let + number;
                    save(id);
                    setBlack(event, id);
                    tab[wS] = letter + "" + number;
                    number++;
                    wS++;
                }
            }
        }
    }

    private void setError(String s) {
        tError.setText(s);
        FadeTransition ft = new FadeTransition(Duration.millis(5000), tError);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }

    private void setBlack(MouseEvent event, String id) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        Scene root = theStage.getScene();
        Button button = (Button) root.lookup("#" + id);
        button.setStyle("-fx-background-color: black");
    }

    private void splitIdChar(String Id) {
        char a = Id.charAt(0);
        for (int i = 0; i < 10; i++) {
            if (alphabet[i] == a) {
                i++;
                letter = i;
                letterM = letter - 1;
            }
        }
        number = Integer.parseInt(Id.substring(1));
    }

    private int getNumber(String Id) {
        return Integer.parseInt(Id.substring(1));
    }

    public void mClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        switch (btn.getId()) {
            case "m1":
                if (i1 != 0) iM = 1;
                else setError("Nie masz ju\u017C statk\u00F3w tego rodzaju");
                break;
            case "m2":
                if (i2 != 0) iM = 2;
                else setError("Nie masz ju\u017C statk\u00F3w tego rodzaju");
                break;
            case "m3":
                if (i3 != 0) iM = 3;
                else setError("Nie masz ju\u017C statk\u00F3w tego rodzaju");
                break;
            case "m4":
                if (i4 != 0) iM = 4;
                else setError("Nie masz ju\u017C statk\u00F3w tego rodzaju");
                break;
        }
    }

    public void switchingDirection(ActionEvent event) {
        Button btn = (Button) event.getSource();
        switch (btn.getId()) {
            case "V":
                direction = 'V';
                break;
            case "H":
                direction = 'H';
                break;
        }
    }

    private boolean validator(MouseEvent event, int x, int stopV, int stopH) {
        Button btn = (Button) event.getSource();
        String bId = btn.getId();
        splitIdChar(bId);
        if (direction == 'V') {
            if (letterM > stopV) {
                for (int i = 0; i < x; i++) {
                    List<String> list = Arrays.asList(tab);
                    stopV++;
                    if (list.contains(stopV + "" + number) || valP(stopV, number, list)) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < x; i++) {
                    List<String> list = Arrays.asList(tab);
                    letterM++;
                    if (list.contains(letterM + "" + number) || valP(letterM, number, list)) {
                        return false;
                    }
                }
            }
        } else if (direction == 'H') {
            if (number > stopH) {
                for (int i = 0; i < x; i++) {
                    List<String> list = Arrays.asList(tab);
                    if (list.contains(letter + "" + stopH) || valP(letter, stopH, list)) {
                        return false;
                    }
                    stopH++;
                }
            } else {
                for (int i = 0; i < x; i++) {
                    List<String> list = Arrays.asList(tab);
                    if (list.contains(letter + "" + number) || valP(letter, number, list)) {
                        return false;
                    }
                    number++;
                }
            }
        }
        return true;
    }

    private boolean valP(int a, int b, List<String> list) {
        return list.contains(a + "" + (b + 1)) || list.contains(a + "" + (b - 1)) || list.contains((a + 1) + "" + b) || list.contains((a + 1) + "" + (b + 1)) || list.contains((a + 1) + "" + (b - 1)) || list.contains((a - 1) + "" + b) || list.contains((a - 1) + "" + (b + 1)) || list.contains((a - 1) + "" + (b - 1));
    }

    private boolean valS(char a, int b, List<String> list, Scene root) {
        String[] tab = {a + "" + (b + 1), a + "" + (b - 1), (char) (a + 1) + "" + b, (char) (a + 1) + "" + (b + 1), (char) (a + 1) + "" + (b - 1), (char) (a - 1) + "" + b, (char) (a - 1) + "" + (b + 1), (char) (a - 1) + "" + (b - 1)};
        for (String x : tab) {
            Button btn = (Button) root.lookup("#d" + x);
            if (btn == null) continue;
            if (list.contains(x) && !btn.getStyleClass().contains("x") && !temp2.contains(x)) {
                return true;
            }
        }
        for (String x : tab) {
            Button btn = (Button) root.lookup("#d" + x);
            if (btn == null) continue;
            if (btn.getStyleClass().contains("x") && !temp2.contains(x)) {
                temp2.add(x);
                if (valS(x.charAt(0), getNumber(x), list, root)) return true;
            }
        }
        return false;
    }

    private void setCircle(char a, int b, MouseEvent mouseEvent) {
        String[] tab = {a + "" + (b + 1), a + "" + (b - 1), (char) (a + 1) + "" + b, (char) (a + 1) + "" + (b + 1), (char) (a + 1) + "" + (b - 1), (char) (a - 1) + "" + b, (char) (a - 1) + "" + (b + 1), (char) (a - 1) + "" + (b - 1)};
        Node source = (Node) mouseEvent.getSource();
        Window theStage = source.getScene().getWindow();
        Scene root = theStage.getScene();
        int p;
        if (player == 1) p = 2;
        else p = 1;
        temp.add(String.valueOf(a + b));
        for (String x : tab) {
            Button btn = (Button) root.lookup("#d" + x);
            if (btn == null) continue;
            if (!btn.getStyleClass().contains("x") && !btn.getStyleClass().contains("circle") && !saver.getIdList(p).contains(x)) {
                btn.setStyle("");
                btn.getStyleClass().add("circle");
                btn.setScaleX(0.369565217);
                btn.setScaleY(0.5);
                saver.addToCircleList(x, player);
            }
        }
        for (String x : tab) {
            Button btn = (Button) root.lookup("#d" + x);
            if (btn == null) continue;
            if (btn.getStyleClass().contains("x") && !temp.contains(x)) {
                splitIdChar(x);
                temp.add(x);
                setCircle(x.charAt(0), number, mouseEvent);
            }
        }
    }

    private void loadCircle(List<String> circles, Map<String, Object> namespace) {
        for (String x : circles) {
            Button button = (Button) namespace.get("d" + x);
            if (button == null) continue;
            button.setStyle("");
            button.getStyleClass().add("circle");
            button.setScaleX(0.369565217);
            button.setScaleY(0.5);
        }
    }

    private void save(String sId) {
        aId[wSs] = sId;
        wSs++;
    }

    private boolean ifAllShotDown(Scene root) {
        int p;
        if (player == 1) p = 2;
        else p = 1;
        for (String x : saver.getIdList(p)) {
            Button btn = (Button) root.lookup("#d" + x);
            if (!btn.getStyleClass().contains("x")) {
                return false;
            }
        }
        return true;
    }

    public void btnShot(MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Window theStage = source.getScene().getWindow();
        Scene root = theStage.getScene();
        if (!ifHaveMove) {
            setError("Nie masz ju\u017C ruch\u00F3w teraz kliknij przycisk \"oddaj tur\u0119 przeciwnikowi\"");
            return;
        }
        Button btn = (Button) mouseEvent.getSource();
        String bId = btn.getId().replaceFirst("d", "");
        Button button = (Button) root.lookup("#d" + bId);
        List<String> list;
        if (player == 1) list = saver.getIdList(2);
        else list = saver.getIdList(1);
        if (list.contains(bId)) {
            button.setStyle("");
            button.getStyleClass().add("x");
            splitIdChar(bId);
            if (valS(bId.charAt(0), number, list, root))
                setError("Trafiony! mo\u017Cesz jeszcze raz odda\u0107 strza\u0142");
            else {
                setError("Trafiony i zatopiony! mo\u017Cesz jeszcze raz odda\u0107 strza\u0142");
                setCircle(bId.charAt(0), number, mouseEvent);
            }
            sId.add(bId);
        } else if (!btn.getStyleClass().contains("x") && !btn.getStyleClass().contains("circle")) {
            ifHaveMove = false;
            btn.setStyle("");
            btn.getStyleClass().add("circle");
            btn.setScaleX(0.369565217);
            btn.setScaleY(0.5);
            setError("Pud\u0142o");
            saver.addToCircleList(bId, player);
        } else setError("W to miejsce nie mo\u017Cesz odda\u0107 strza\u0142u");
        if (ifAllShotDown(root)) {
            windowSave = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Wygra\u0142e\u015B");
            try {
                Parent winRoot = FXMLLoader.load(getClass().getResource("WIN.fxml"));
                window.setScene(new Scene(winRoot, 300, 100));
                window.setResizable(false);
                Toolkit.getDefaultToolkit().beep();
                window.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnPC(ActionEvent event) {
        if (ifHaveMove && block1 && block2) {
            setError("Nie mo\u017Cesz odda\u0107 tury poniewa\u017C mo\u017Cesz jeszcze odda\u0107 strza\u0142");
            return;
        }
        if (block1 && block2) {
            ((Node) event.getSource()).getScene().getWindow().hide();
            saver.addToIdS(sId, player);
            if (player == 1) player = 2;
            else if (player == 2) player = 1;
            doPC(event);
            return;
        }
        if (i1 != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            setError("Aby odda\u0107 tur\u0119 najpierw postaw wszystkie dost\u0119pne statki na plansz\u0119");
            return;
        }

        if (player == 1) block1 = true;
        if (player == 2) block2 = true;

        saver.setId(aId, player);
        if (player == 1) player = 2;
        else if (player == 2) player = 1;

        doPC(event);
    }

    private void doPC(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BTS.fxml"));
            Scene BTS_scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(BTS_scene);
            root.requestFocus();
            window.show();
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
        load(saver.getId(player), root);
        if ((player == 1 && block1) || (player == 2 && block2)) {
            if (player == 1) {
                loadS(saver.getIdS(1), root);
                loadCircle(saver.getCircleList(1), namespace);
            } else {
                loadS(saver.getIdS(2), root);
                loadCircle(saver.getCircleList(2), namespace);
            }
            gridPane.setDisable(true);
            gridPaneD.setDisable(false);
        }else{
            gridPane.setDisable(false);
            gridPaneD.setDisable(true);
        }
        window.show();
    }

    private void load(String[] aId, Parent root) {
        if (aId == null) return;
        for (int i = 0; i <= 19; i++) {
            String id = aId[i];
            if (aId[i] != null) {
                Button button = (Button) root.lookup("#" + id);
                button.setStyle("-fx-background-color: black");
            }
        }
    }

    private void loadS(List<String> aId, Parent root) {
        if (aId.isEmpty()) return;
        for (String id : aId) {
            if (id != null) {
                Button button = (Button) root.lookup("#d" + id);
                button.setStyle("");
                button.getStyleClass().add("x");
            }
        }
    }

    public void btnEndGame() {
        System.exit(0);
    }

    public void btnSeeEnemyShips() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        windowSave.setScene(scene);
        root.requestFocus();

        Map<String, Object> namespace = loader.getNamespace();
        GridPane gridPane = (GridPane) namespace.get("GP");
        GridPane gridPaneD = (GridPane) namespace.get("GPd");
        load(saver.getId(player == 1 ? 2 : 1), root);
        if ((player == 1 && block1) || (player == 2 && block2)) {
            if (player == 1) {
                loadS(saver.getIdS(2), root);
                loadCircle(saver.getCircleList(2), namespace);
            } else {
                loadS(saver.getIdS(1), root);
                loadCircle(saver.getCircleList(1), namespace);
            }
            gridPane.setDisable(true);
            gridPaneD.setDisable(true);
        }
        windowSave.show();
    }

    public void btnNewGame(ActionEvent event) throws IOException {
        saver.clear();
        player = 1;
        block1 = false;
        block2 = false;

        windowSave.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);

        window.setScene(scene);
        root.requestFocus();
        Map<String, Object> namespace = loader.getNamespace();
        GridPane gridPaneD = (GridPane) namespace.get("GPd");
        gridPaneD.setDisable(true);
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        window.setX((d.width >> 1) -(window.getWidth()/2));
        window.setY((d.height >> 1) -(window.getHeight()/2));
        window.show();
    }
}