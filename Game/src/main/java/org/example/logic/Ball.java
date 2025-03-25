package org.example.logic;

import java.util.ArrayList;

public class Ball extends Entity {
    final int MOVE_LENGTH = 10;
    public Ball(int x, int y, String url) {
        super(x, y, url);
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


    // Neefektivní metoda a řešení
    public ArrayList<org.example.logic.Coordinates> getAllCoordinates(){
        ArrayList<org.example.logic.Coordinates> ballCoords = new ArrayList<>();
        for (int i = coord.x; i < coord.x + image.getWidth(null); i++){
            for (int j = coord.y; j < coord.y + image.getHeight(null); j++){
                ballCoords.add(new Coordinates(i, j));
            }
        }
        return ballCoords;
    }
}
