package JDK.lesson2;

import JDK.lesson2.server.Server;
import JDK.lesson2.server.ServerWindow;
import JDK.lesson2.client.ClientGUI;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        Server server = serverWindow.returnServer();

        new ClientGUI(server);
        new ClientGUI(server);
        new ClientGUI(server);

    }
}
