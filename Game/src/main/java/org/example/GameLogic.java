package org.example;

import org.example.logic.*;

import java.awt.*;
import java.util.ArrayList;

public class GameLogic {

    final int MOVE_LENGHT = 10;
    Ball ball;
    ArrayList<Enemy> enemies;

    public GameLogic() {


        ball = new Ball(20,20,"player_cat.png");
        enemies = new ArrayList<>();
        Enemy enemy1 = new Enemy(150,50,"leBomba_50x50.png");
        Enemy enemy2 = new Enemy(150,150,"leBomba_50x50.png");
        Enemy enemy3 = new Enemy(250,50,"leBomba_50x50.png");
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);

    }

    public void update() {
        for (Enemy enemy: enemies){
            int differenceX = Math.abs(enemy.coord.x - ball.coord.x);
            int differenceY = Math.abs(enemy.coord.y - ball.coord.y);
            if (differenceX > differenceY){
                // Possible directions: LEFT, RIGHT
                if (enemy.coord.x > ball.coord.x){
                    // LEFT
                    enemy.move(MOVE_LENGHT, Direction.LEFT);
                } else {
                    // RIGHT
                    enemy.move(MOVE_LENGHT, Direction.RIGHT);
                }
            } else {
                // Possible directions: UP, DOWN
                if (enemy.coord.y > ball.coord.y){
                    // UP
                    enemy.move(MOVE_LENGHT, Direction.UP);
                } else {
                    // DOWN
                    enemy.move(MOVE_LENGHT, Direction.DOWN);
                }
            }
        }
    }
}
