package JDK.lesson1.client;

import JDK.lesson1.server.*;

public class Client {
    private boolean connected;
    private String name;
    private final ClientView clientView;
    private final Server server;

    // Конструктор класса Client

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    // Метод обеспечивает подключение пользователя к серверу.

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    // Метод disconnectFromServer - обеспечивает отключение пользователя от сервера.

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            showOnWindow("Вы отключены от сервера!");
        }
    }

    // Метод answerFromServer - ответ от сервера.

    public void answerFromServer(String text) {
        showOnWindow(text);
    }

    // Метод sendMessage предназначен для отправки сообщений на сервер.

    public void sendMessage(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.sendMessage(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    // Метод для возврата имени клиента.

    public String getName() {
        return name;
    }

    // Метод обращения к окну, выводящий текст на печать с переносом очередного

    private void showOnWindow(String text) {
        clientView.showMessage(text + "\n");
    }
}