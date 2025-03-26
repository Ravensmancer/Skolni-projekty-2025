package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class Entity {
    public org.example.logic.Coordinates coord;
    public int width;
    public int height;
    public Color color;

    public Entity(int x, int y, int width, int height, Color color) {
        this.coord = new Coordinates(x,y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public Rectangle getEntityRectangle(){
        return new Rectangle(coord.x, coord.y, width, height);
    }

    public void move(int steps, Direction direction){
        switch (direction){
            case UP -> {
                coord.y -= steps;
            }
            case DOWN -> {
                coord.y += steps;
            }
            case LEFT -> {
                coord.x -= steps;
            }
            case RIGHT -> {
                coord.x += steps;
            }
        }
    }

}
