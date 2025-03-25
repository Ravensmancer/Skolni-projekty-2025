package org.example;

import org.example.logic.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    GameLogic logic;

    public Game() {
        logic = new GameLogic();
        GameGraphics graphics = new GameGraphics(logic);
        graphics.render(logic);


        graphics.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    logic.ball.moveLeft();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    logic.ball.moveRight();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    logic.ball.moveUp();
                    graphics.render(logic);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    logic.ball.moveDown();
                    graphics.render(logic);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Rectangle pointOfCollision = new Rectangle(e.getX(), e.getY()-30, 1,1);
                Rectangle ballPosition = logic.ball.getEntityRectangle();
                //for (Coordinates coord: logic.ball.getAllCoordinates()){
                    /*
                    System.out.println("Souřadnice coord.x =" + coord.x);
                    System.out.println("Souřadnice coord.y =" + coord.y);
                    System.out.println("Souřadnice kliku x =" + e.getX());
                    System.out.println("Souřadnice kliku y =" + e.getY());
                     */

                if (pointOfCollision.intersects(ballPosition)){
                    logic.ball.move(100, Direction.RIGHT);
                    graphics.render(logic);
                }
                //}
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphics.render(logic);
            }
        });

        timer.start();




    }

    public static void main(String[] args) {
        new Game();
    }
}
