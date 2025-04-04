package org.example;

import org.example.logic.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Siege {
    SiegeLogic logic;

    public Siege() {
        logic = new SiegeLogic();
        SiegeGraphics graphics = new SiegeGraphics(logic);
        graphics.render(logic);



        graphics.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(logic.knight.coord.x + " " + logic.knight.coord.y);
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    logic.knight.moveLeft();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    logic.knight.moveRight();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    logic.knight.moveUp();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    logic.knight.moveDown();
                    graphics.render(logic);
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphics.render(logic);

            }
        });

        timer.start();




    }

    public static void main(String[] args) {
        new Siege();
    }
}
