package Statki;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    public Socket incoming;
    public ObjectInputStream inStream;
    public ObjectOutputStream outStream;
    private String username;
    //ClientMessage cm;

    public ServerThread(Socket i) {
        incoming = i;

        try {
            outStream = new ObjectOutputStream(incoming.getOutputStream());
            inStream = new ObjectInputStream(incoming.getInputStream());

            //pobranie nazwy uzytkownika od klienta
            username = (String) inStream.readObject();

            String msg = "<<SERVER>>: Witaj " + username + "!";
            outStream.writeObject(msg);
        } catch (IOException e) {
            System.out.println("Nie mo¿na utworzyc strumieni WE/WY");
        } catch (ClassNotFoundException e) {

        }
    }

    @Override
    public void run() {
        try {
            try {
                boolean done = false;
                while (!done) {
//                    String line;
                    try {
                        /*cm = (ClientMessage) inStream.readObject();
                        Server.getInstance().passMsg(cm);*/
                    } catch (Exception e) { }
                }
            } finally {
                incoming.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    /*public void writeMsg(ClientMessage msg) {
        try {
            outStream.writeObject(msg);
        } catch (Exception e) {
            //TODO obs³u¿yæ zerwanie po³¹czenia
            System.out.println("::Nie uda³o siê wys³aæ widomoœci::");
        }
    }*/
}
