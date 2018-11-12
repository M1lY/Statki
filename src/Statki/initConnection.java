package Statki;

public class initConnection {
    boolean isHost;
    public void init(ConnectionParams params){
        this.isHost=params.isHost();
        if (isHost){
            Server.getInstance().init(5555);
            Server.getInstance().start();
        }

    }
}
