package org.example;

import org.example.logic.Enemy;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame {
    GameLogic logic;
    Draw draw;

    public GameGraphics(GameLogic logic) throws HeadlessException {
        this.logic = logic;

        draw = new Draw();
        add(draw);

        setSize(1024,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);

    }

    public void render(GameLogic logic, double deltaTime) {
        this.logic = logic;
        repaint();
    }


    private class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            //Vykresleni Hrace
            g.drawImage(logic.player.image, logic.player.coord.x - logic.player.image.getWidth(null) / 2,
                    logic.player.coord.y - logic.player.image.getHeight(null) / 2, null);

            //Vykresleni Enemy
            for (Enemy enemy : logic.enemies) {
                g.drawImage(enemy.image, enemy.coord.x - enemy.image.getWidth(null) / 2,
                        enemy.coord.y - enemy.image.getHeight(null) / 2, null);
            }
        }
    }
}
