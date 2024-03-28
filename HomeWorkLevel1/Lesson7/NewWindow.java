package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWindow extends JFrame {
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;

    NewWindow(MainWindow mainWindow) {

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("NEW WINDOW");
        JButton btnBack = new JButton("Back");
        JButton btnExit = new JButton("Exit");
        add(new JLabel("Hello, new window!!!"));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(true);

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1, 2));
        panelTop.add(btnBack);
        panelTop.add(btnExit);

        add(panelTop, BorderLayout.SOUTH);

        setVisible(false);
    }
}
