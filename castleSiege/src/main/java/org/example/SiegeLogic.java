package org.example;

import org.example.logic.*;


import java.awt.*;
import java.util.ArrayList;

public class SiegeLogic {

    int maxDistance = 100;
    final int MOVE_LENGHT = 10;
    Knight knight;
    Castle castle;
    int SWlength = 70;
    int thrustRange = 70;


    public SiegeLogic() {


        knight = new Knight(800,100,50, 50, Color.GRAY);
        castle = new Castle(100, 100,60, 60,Color.DARK_GRAY );


    }

    public int getDistance(int Kx, int Ky, int Cx, int Cy) {
        return (int) Math.sqrt(Math.pow(Kx - Cx, 2) + Math.pow(Ky - Cy, 2));
    }

    public int dangerDistance(int distHR, int sizeSW){
        double result = 1-Math.floor(1/(1+Math.exp(-10*(distHR-sizeSW-30)))+0.5);
        return (int) result;
    }
    public int getSwordX(int Kx, int Ky, int Cx, int Cy){
        return (int) Kx-(Kx-Cx)*(SWlength+thrustRange*dangerDistance(getDistance(Kx, Ky, Cx, Cy), SWlength))/getDistance(Kx, Ky, Cx, Cy);

        //return (int) (knight.coord.x + knight.width/2)-Math.abs((knight.coord.x + knight.width/2)-(castle.coord.x + castle.width/2))*100/getDistance((knight.coord.x + knight.width/2), (knight.coord.y + knight.height/2), (castle.coord.x + castle.width/2), (castle.coord.y + castle.height/2));
        //return (int) knight.coord.x-Math.abs(knight.coord.x-castle.coord.x)*100/getDistance(knight.coord.x, knight.coord.y, castle.coord.x, castle.coord.y);
    }
    public int getSwordY(int Kx, int Ky, int Cx, int Cy){
        return (int) Ky+(Cy-Ky)*(SWlength+thrustRange*dangerDistance(getDistance(Kx, Ky, Cx, Cy), SWlength))/getDistance(Kx, Ky, Cx, Cy);

        //return (int) (knight.coord.y + knight.height/2)-Math.abs((castle.coord.y + castle.height/2)-(knight.coord.y + knight.height/2))*100/getDistance((knight.coord.x + knight.width/2), (knight.coord.y + knight.height/2), (castle.coord.x + castle.width/2), (castle.coord.y + castle.height/2));
        //return (int) knight.coord.y-Math.abs(castle.coord.y-knight.coord.y)*100/getDistance(knight.coord.x, knight.coord.y, castle.coord.x, castle.coord.y);
    }

    public void update() {
       /* if (knightDistance()) {
            System.out.println("Rytíř je dost blízko k hradu, může prodloužit meč!");
        } else {
            System.out.println("Rytíř je příliš daleko.");
        }*/
    }
}
