package Statki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Saver {
    private static String[] id1 = new String[20];               //do zapisu ustawienia statk�w
    private static String[] id2 = new String[20];               //do zapisu ustawienia statk�w
    private static List<String> idList1 = new ArrayList<>();    //do zapisu ustawienia statk�w (lista)
    private static List<String> idList2 = new ArrayList<>();    //do zapisu ustawienia statk�w (lista)
    private static List<String> idListS1 = new ArrayList<>();   //do zapisu strza��w
    private static List<String> idListS2 = new ArrayList<>();   //do zapisu strza��w
    private static List<String> circle1 = new ArrayList<>();    //do zapisu nie trafionych strza��w
    private static List<String> circle2 = new ArrayList<>();    //do zapisu nie trafionych strza��w

    List<String> getCircleList(int p) {
        if(p==1) return circle1;
        else return circle2;
    }

    void addToCircleList(String circle, int p) {
        if(p==1) Saver.circle1.add(circle);
        else Saver.circle2.add(circle);
    }


    List<String> getIdList(int p) {
        if(p==1) return idList1;
        else return idList2;
    }



    void addToIdS(List<String> idS1, int p) {
        if(p==1) Saver.idListS1.addAll(idS1);
        else Saver.idListS2.addAll(idS1);
    }

    List<String> getIdS(int p) {
        if(p==1) return idListS1;
        else return idListS2;
    }


    void setId(String[] id, int p) {
        if(p==1){
            id1 = id;
            Collections.addAll(idList1, id);
        }else{
            id2 = id;
            Collections.addAll(idList2, id);
        }
    }

    String[] getId(int p) {
        if(p==1) return id1;
        else return id2;
    }

    void clear(){
        id1=null;
        id2=null;
        idList1.clear();
        idList2.clear();
        idListS1.clear();
        idListS2.clear();
        circle1.clear();
        circle2.clear();
    }
}
