package org.example;

import org.example.logic.*;

import java.util.ArrayList;

public class GameLogic {

    //final int MOVE_LENGHT = 10;
    Player player;
    ArrayList<Enemy> enemies;

    public GameLogic() {


        player = new Player(20,20,"player_cat.png");
        enemies = new ArrayList<>();
        Enemy enemy1 = new Enemy(150,50,"leBomba_50x50.png");
        Enemy enemy2 = new Enemy(150,150,"leBomba_50x50.png");
        Enemy enemy3 = new Enemy(250,50,"leBomba_50x50.png");
        Enemy enemy4 = new Enemy(250,100,"leBomba_50x50.png");
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);

    }

    public void update(double deltaTime) {
        player.update(deltaTime);

        for (Enemy enemy: enemies){
            int enemyMoveSpeed = 150;
            int differenceX = Math.abs(enemy.coord.x - player.coord.x);
            int differenceY = Math.abs(enemy.coord.y - player.coord.y);

            if (differenceX > differenceY){
                // Possible directions: LEFT, RIGHT
                if (enemy.coord.x > player.coord.x){
                    // LEFT
                    enemy.move(deltaTime, Direction.LEFT, enemyMoveSpeed);
                } else {
                    // RIGHT
                    enemy.move(deltaTime, Direction.RIGHT, enemyMoveSpeed);
                }
            } else {
                // Possible directions: UP, DOWN
                if (enemy.coord.y > player.coord.y){
                    // UP
                    enemy.move(deltaTime, Direction.UP, enemyMoveSpeed);
                } else {
                    // DOWN
                    enemy.move(deltaTime, Direction.DOWN, enemyMoveSpeed);
                }
            }
        }
    }
}
