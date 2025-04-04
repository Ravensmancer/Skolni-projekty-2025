package org.example;

import org.example.logic.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    GameLogic logic;
    boolean movingUp, movingDown, movingLeft, movingRight;

    public Game() {
        logic = new GameLogic();
        GameGraphics graphics = new GameGraphics(logic);
        graphics.render(logic, 0.016);

        graphics.setFocusable(true); // Nastavení, aby JPanel přijímal klávesové vstupy
        graphics.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Tisknout, když jsou klávesy stisknuty
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        movingLeft = true;
                        System.out.println("LEFT pressed");
                        break;
                    case KeyEvent.VK_RIGHT:
                        movingRight = true;
                        System.out.println("RIGHT pressed");
                        break;
                    case KeyEvent.VK_UP:
                        movingUp = true;
                        System.out.println("UP pressed");
                        break;
                    case KeyEvent.VK_DOWN:
                        movingDown = true;
                        System.out.println("DOWN pressed");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        movingLeft = false;
                        System.out.println("LEFT released");
                        break;
                    case KeyEvent.VK_RIGHT:
                        movingRight = false;
                        System.out.println("RIGHT released");
                        break;
                    case KeyEvent.VK_UP:
                        movingUp = false;
                        System.out.println("UP released");
                        break;
                    case KeyEvent.VK_DOWN:
                        movingDown = false;
                        System.out.println("DOWN released");
                        break;
                }
            }
        });

        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        });

        Timer timer = new Timer(16, new ActionListener() { // Timer pro 60 FPS
            @Override
            public void actionPerformed(ActionEvent e) {
                double deltaTime = 16.0 / 1000.0; // předpokládáme 60 FPS

                // Pohyb na základě stavu kláves
                if (movingLeft) {
                    logic.player.move(deltaTime, Direction.LEFT, logic.player.moveSpeed);
                }
                if (movingRight) {
                    logic.player.move(deltaTime, Direction.RIGHT, logic.player.moveSpeed);
                }
                if (movingUp) {
                    logic.player.move(deltaTime, Direction.UP, logic.player.moveSpeed);
                }
                if (movingDown) {
                    logic.player.move(deltaTime, Direction.DOWN, logic.player.moveSpeed);
                }

                // Aktualizace logiky a vykreslení
                logic.update(deltaTime);
                graphics.render(logic, deltaTime);
            }
        });

        timer.start();




    }

    public static void main(String[] args) {
        new Game();
    }
}
