package org.example;

import org.example.logic.Castle;

import javax.swing.*;
import java.awt.*;

public class SiegeGraphics extends JFrame {
    SiegeLogic logic;
    Draw draw;

    public SiegeGraphics(SiegeLogic logic) throws HeadlessException {
        this.logic = logic;

        draw = new Draw();
        add(draw);

        setSize(1024,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void render(SiegeLogic logic) {
        this.logic = logic;
        repaint();
    }


    private class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(logic.knight.color);
            g.fillOval(logic.knight.coord.x, logic.knight.coord.y, logic.knight.width, logic.knight.height);
            g.setColor(logic.castle.color);
            g.fillRect(logic.castle.coord.x, logic.castle.coord.y, logic.castle.width, logic.castle.height);
            //g.drawLine(logic.castle.coord.x + logic.castle.width/2, logic.castle.coord.y + logic.castle.height/2, logic.knight.coord.x + logic.knight.width/2, logic.knight.coord.y + logic.knight.height/2);

            g.drawLine(logic.knight.coord.x + logic.knight.width/2,
                    logic.knight.coord.y + logic.knight.height/2,
                    logic.getSwordX(
                            logic.knight.coord.x + logic.knight.width/2,
                            logic.knight.coord.y + logic.knight.height/2,
                            logic.castle.coord.x + logic.castle.width/2,
                            logic.castle.coord.y + logic.castle.height/2),
                    logic.getSwordY(
                            logic.knight.coord.x + logic.knight.width/2,
                            logic.knight.coord.y + logic.knight.height/2,
                            logic.castle.coord.x + logic.castle.width/2,
                            logic.castle.coord.y + logic.castle.height/2)
            );

        }
    }
}
