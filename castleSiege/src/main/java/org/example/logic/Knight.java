package org.example.logic;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Entity {
    final int MOVE_LENGTH = 10;
    public Knight(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void moveLeft(){
        move(MOVE_LENGTH, org.example.logic.Direction.LEFT);
    }
    public void moveRight(){
        move(MOVE_LENGTH, org.example.logic.Direction.RIGHT);
    }
    public void moveUp(){
        move(MOVE_LENGTH, org.example.logic.Direction.UP);
    }
    public void moveDown(){
        move(MOVE_LENGTH, Direction.DOWN);
    }

}
