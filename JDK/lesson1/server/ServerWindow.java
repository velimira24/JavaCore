package JDK.lesson1.server;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

// здесь создаем окна Чат сервера

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    JButton btnStart, btnStop;
    JTextArea log;
    private Server server;

    // Метод запуска окна Чат сервер

    public ServerWindow() {
        setting();
        createPanel();
        setVisible(true);
    }

    /**
     * Метод setting устанавливает свойства для окна приложения.
     * Метод setDefaultCloseOperation() обеспечивает закрытие приложения при
     * закрытии окна.
     * Методы setSize() и setResizable() устанавливают размеры окна и возможность
     * его изменения пользователем.
     * Метод setTitle() изменяет заголовок окна, а setLocationRelativeTo() размещает
     * окно относительно экрана.
     * Создается экземпляр класса Server с передачей текущего окна в качестве
     * аргумента, а также объекта FileStorage.
     */
    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        server = new Server(this, new FileStorage());
    }

    /**
     * Метод getConnection возвращает экземпляр класса Server.
     * 
     * @return экземпляр класса Server
     */
    public Server getConnection() {
        return server;
    }

    /**
     * Метод createPanel предназначен для создания компонентов "Chat server".
     * Создается объект JTextArea, который представляет собой область для
     * отображения текста.
     * Затем этот компонент добавляется на панель с помощью метода add().
     */
    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    /**
     * Метод createButtons создает кнопки "Старт" и "Стоп", предназначенные для
     * запуска и остановки сервера, добавляет их на панель
     * 
     * @return панель с добавленными кнопками.
     */
    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void showMessage(String msg) {
        log.append(msg);
    }
}