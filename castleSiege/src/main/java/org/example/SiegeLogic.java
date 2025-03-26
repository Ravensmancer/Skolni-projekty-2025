package org.example;

import org.example.logic.*;

import java.awt.*;
import java.util.ArrayList;

public class SiegeLogic {

    final int MOVE_LENGHT = 10;
    Knight knight;
    Castle castle;
    Sword sword;

    public SiegeLogic() {


        knight = new Knight(800,100,50, 50, Color.GRAY);
        castle = new Castle(100, 100,60, 60,Color.DARK_GRAY );
        sword = new Sword(knight.coord.x-10, knight.coord.y+20, 10, 20, Color.lightGray);

    }

    public void update() {
        while(castle.coord.x == knight.coord.x){
            sword.width = sword.width+40;
        }

    }
}
