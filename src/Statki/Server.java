package Statki;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    static Server instance;
    private ServerSocket s;
    private int port;
    private ServerThread clients[];
    private int clientCount;
    private boolean done;

    public Server() {
    }

    public static Server getInstance() {
        if(null == instance) {
            instance = new Server();
        }
        return instance;
    }

    public void init(int port) {
        clients = new ServerThread[2];
        clientCount = 0;
        this.port = port;
    }

    public void run() {
        done = false;
        try {
            //TODO przechwycic wyjatek Exception (Port jest juz w uzyciu)
            s = new ServerSocket(port);

            //nasluchiwanie czy jest nowe polaczenie i tworzenie watkow dla klientow
            while (!done) {
                System.out.println("Oczekuje na pol¹czenie...");
                Socket incoming = s.accept();

                if(done)
                    break;

                System.out.println("-->Uzyskano po³¹czenie od: " + incoming.getInetAddress() + ":" + incoming.getPort());
                ServerThread connectedClient = new ServerThread(incoming);
                addClient(connectedClient);
                connectedClient.start();
            }
            //gdy zatrzymano serwer
            try {
                s.close();
                for (int i = 0; i < clientCount; i++) {
                    ServerThread client = clients[i];
                    client.inStream.close();
                    client.outStream.close();
                    client.incoming.close();
                }
            } catch (IOException e) {
                System.out.println("Wyj¹tek podczas zamykania serwera i klientów: " + e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*public void passMsg(ClientMessage msg) {
        for (int i = 0; i < clientCount; i++) {
            if(clients[i].getUsername() != msg.getSourceUsername()) {
                clients[i].writeMsg(msg);
            }
        }
    }*/

    private void addClient(ServerThread c) {
        if(clientCount < 2) {
            clients[clientCount] = c;
            clientCount++;
        } else {
            System.out.println("Serwer pe³ny!");
            //TODO blokowaæ po³¹czenie trzeciego gracza
        }
    }

    public void shutDown() {
        done = true;
    }
}

