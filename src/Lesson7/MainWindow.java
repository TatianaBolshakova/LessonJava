package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MainWindow extends JFrame {

        private static final int WINDOW_WIDTH = 500;
        private static final int WINDOW_HEIGHT = 500;
        private static final int WINDOW_POSX = 500;
        private static final int WINDOW_POSY = 500;

        private final Setting settingWindow;
        private final GameMap gameMap;
        private final NewWindow newWindow;

        MainWindow() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setLocation(WINDOW_POSX, WINDOW_POSY);
            setTitle("Крестики-нолики");

            settingWindow = new Setting(this);
            newWindow = new NewWindow(this);
            gameMap = new GameMap();

            JButton btnStart = new JButton("Start new game");
            btnStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    settingWindow.setVisible(true);
                }
            });

            JButton btnExitGame = new JButton("Close");
            btnExitGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            JButton btnShowNewWindow = new JButton("Show new window");
            btnShowNewWindow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    newWindow.setVisible(true);
                }
            });

            JPanel panelBottom = new JPanel();
            panelBottom.setLayout(new GridLayout(1, 3));
            panelBottom.add(btnStart);
            panelBottom.add(btnExitGame);
            panelBottom.add(btnShowNewWindow);

            add(panelBottom, BorderLayout.SOUTH);

            setResizable(false);
            setVisible(true);
        }

        void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
            gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
        }

    }
