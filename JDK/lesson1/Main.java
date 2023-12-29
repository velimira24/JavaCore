package JDK.lesson1;

import JDK.lesson1.client.*;
import JDK.lesson1.server.*;

//Это  точка входа в программу.
// будет два окна и сервер
public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}