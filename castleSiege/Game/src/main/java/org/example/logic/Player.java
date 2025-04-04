package org.example.logic;

//import java.util.ArrayList;

public class Player extends Entity {
    private boolean up, down, left, right;
    public double moveSpeed = 200;

    //final int MOVE_LENGTH = 10;
    public Player(int x, int y, String url) {
        super(x, y, url);
    }

    public void moveUp() { up = true; }
    public void moveDown() { down = true; }
    public void moveLeft() { left = true; }
    public void moveRight() { right = true; }

    public void stopUp() { up = false; }
    public void stopDown() { down = false; }
    public void stopLeft() { left = false; }
    public void stopRight() { right = false; }

    public void update(double deltaTime) {
        // Pohyb hráče podle směru
        if (up) move(deltaTime, Direction.UP, moveSpeed);
        if (down) move(deltaTime, Direction.DOWN, moveSpeed);
        if (left) move(deltaTime, Direction.LEFT, moveSpeed);
        if (right) move(deltaTime, Direction.RIGHT, moveSpeed);
    }
    /*public void moveLeft(){
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
    }*/
    // Neefektivní metoda a řešení
    /*public ArrayList<org.example.logic.Coordinates> getAllCoordinates(){
        ArrayList<org.example.logic.Coordinates> ballCoords = new ArrayList<>();
        for (int i = coord.x; i < coord.x + image.getWidth(null); i++){
            for (int j = coord.y; j < coord.y + image.getHeight(null); j++){
                ballCoords.add(new Coordinates(i, j));
            }
        }
        return ballCoords;
    }*/
}
