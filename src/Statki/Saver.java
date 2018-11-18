package Statki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Saver {
    private static String[] id1 = new String[20]; //do podgl¹du ustawienia
    private static String[] id2 = new String[20]; //do podgl¹du ustawienia
    private static List<String> idList1 = new ArrayList<>(); //do zapisu statków pozosta³ych do zestrzelania
    private static List<String> idList2 = new ArrayList<>(); //do zapisu statków pozosta³ych do zestrzelania
    private static String[] idS1 = new String[20]; //do zapisu strza³ów
    private static String[] idS2 = new String[20]; //do zapisu strza³ów

    List<String> getIdList(int p) {
        if(p==1) return idList1;
        else return idList2;
    }

    void delIdList(String id,int p){
        if(p==1) idList1.remove(id);
        else idList2.remove(id);
    }


    void setIdS(String[] idS1, int p) {
        if(p==1) Saver.idS1 = idS1;
        else Saver.idS2 = idS2;
    }
    String[] getIdS(int p) {
        if(p==1) return idS1;
        else return idS2;
    }


    void setId(String[] id, int p) {
        if(p==1){
            this.id1 = id;
            for(int i=0;i<id.length;i++) this.idList1.add(id[i]);
        }else{
            this.id2 = id;
            for(int i=0;i<id.length;i++) this.idList2.add(id[i]);
        }
    }

    String[] getId(int p) {
        if(p==1) return id1;
        else return id2;
    }
}
