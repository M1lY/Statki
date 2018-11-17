package Statki;

class Saver {
    private static String[] id1 = new String[20];
    private static String[] id2 = new String[20];


    void setId(String[] id, int p) {
        if(p==1) this.id1 = id;
        else if(p==2) this.id2 = id;
    }

    String[] getId(int p) {
        if(p==1) return id1;
        else return id2;
    }
}
