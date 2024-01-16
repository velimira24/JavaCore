package JDK.lesson2.server;

import JDK.lesson2.client.*;
import JDK.lesson2.repository.*;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerView serverView;
    private Repository repository;
    public static final String LOG_PATH = "src/main/java/ru/geekbrains/server/repository/log.txt";

    List<Client> clientList;

    boolean work;

    public Server(ServerView serverView) {
        clientList = new ArrayList<>();
        this.serverView = serverView;
        this.repository = new Storage(LOG_PATH);
    }

    public void startServer() {
        work = true;
    }

    public void stopServer() {
        work = false;
    }

    public boolean getStatusServer() {
        return work;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client) {
        if (client != null) {
            clientList.remove(client);
        }
    }

    public void serverDown(Client client) {
        if (client != null) {
            client.disconnectFromServer();
        }
    }

    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        serverView.showMessage(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client : clientList) {
            client.serverAnswer(text);
        }
    }

    private void saveInLog(String text) {
        repository.saveInLog(text);
    }

    public String getHistory() {
        return repository.getHistory();
    }

}