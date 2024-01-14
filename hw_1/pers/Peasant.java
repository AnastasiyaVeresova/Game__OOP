package oop.hw_1.pers;

import oop.hw_1.Hero;

import java.util.Random;

public class Peasant extends Hero {
    static  private Random rand = new Random();
    public Peasant(String nameHero, int posX, int posY) {
        super(100, 100, 0, new int[]{0, 0}, nameHero, posX, posY);
        initiative = 0;
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;

    @Override
    public String toString() {
        return ("Крестьянин: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
    }

    @Override
    public boolean shoot(Hero other) {
        return false;
    }


}
