package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class Entity {
    public org.example.logic.Coordinates coord; //Vytvoření instance Coordinates
    public Image image;

    public Entity(int x, int y, String url) {
        this.coord = new Coordinates(x,y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url)); //Získání obrázku
        image = ii.getImage();
    }

    public Rectangle getEntityRectangle(){
        //Vytvoření těla entity kde coord je středem a nikoliv spodním levím rohem
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        return new Rectangle(coord.x - width / 2, coord.y - height / 2, width, height);
    }

    public void move(double deltaTime, Direction direction, double moveSpeed){
        int steps = (int) (moveSpeed * deltaTime);
        //System.out.println("Moving " + direction + " by " + steps);
        switch (direction){
            case UP -> coord.y -= steps;

            case DOWN -> coord.y += steps;

            case LEFT -> coord.x -= steps;

            case RIGHT -> coord.x += steps;

        }
    }

}
