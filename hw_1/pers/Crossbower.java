package oop.hw_1.pers;

import oop.hw_1.Roles.Archer;

public class Crossbower extends Archer {

    float minDist;

    public Crossbower(String nameHero, int posX, int posY, float minDist) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
        this.minDist = minDist;
    }
//    protected Vector2 position;

    @Override
    public String toString() {
        return ("Арбалетчик: " + super.toString());
    }

    @Override
    public String getInfo() {
        return "Арбалетчик";
    }



}