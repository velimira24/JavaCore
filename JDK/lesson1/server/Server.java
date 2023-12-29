package JDK.lesson1.server;

import JDK.lesson1.client.Client;
import java.util.ArrayList;
import java.util.List;

//Класс Server предназначен для описания логики работы Сервера и его взаимодействия с пользователем.

public class Server {
    private boolean work;
    private final ServerView serverView;
    private final List<Client> clientList;
    private final Repository repository;

    public Server(ServerView serverView, Repository repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientList = new ArrayList<>();
    }

    // Метод запуска Сервера. Если не работает, но поступила команда Старт, то
    // сервер запускается.
    // При поступлении повторной команды и работающем Сервере, выдается
    // соответствующее сообщение.

    public void start() {
        if (work) {
            showOnWindow("Сервер уже запущен.");
        } else {
            work = true;
            showOnWindow("Сервер запущен.");
        }
    }

    // Метод остановки Сервера. Если Сервер остановлен, но поступила команда Стоп,
    // то выдается соответствующее сообщение.
    // При работающем Сервере происходит его остановка.

    public void stop() {
        if (!work) {
            showOnWindow("Сервер уже остановлен.");
        } else {
            work = false;
            for (Client client : clientList) {
                disconnectUser(client);
            }
            showOnWindow("Сервер остановлен.");
        }
    }

    // Метод connectUser предназначен для подключения пользователя к беседе в чате.
    // Если сервер работает, то пользователя подключают к беседе, выводя
    // соответствующее сообщение.

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        showOnWindow(client.getName() + " подключился к беседе.");
        return true;
    }

    // Метод disconnectUser предназначен для отключения пользователя от беседы
    // вчате.

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (client != null) {
            client.disconnectFromServer();
            showOnWindow(client.getName() + " отключился от беседы.");
        }
    }

    // Метод sendMessage определяет порядок действий приложения при отправке
    // сообщения пользователем.

    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        showOnWindow(text);
        answerAll(text);
        saveInHistory(text);
    }

    // Метод getHistory обращается к интерфейсу "Репозиторий" для вывода текста

    public String getHistory() {
        return repository.readText().toString();
    }

    // позволяет формировать ответ, доступный всем пользователям.

    private void answerAll(String text) {
        for (Client client : clientList) {
            client.answerFromServer(text);
        }
    }

    // Метод showOnWindow - запускает метод показа сообщения.
    // @param text - текст сообщения.
    private void showOnWindow(String text) {
        serverView.showMessage(text + "\n");
    }

    // Метод saveInHistory предназначен для вызова метода сохранения данных в файл.
    // @param text текст сообщения.

    private void saveInHistory(String text) {
        repository.saveMessage(text);
    }
}