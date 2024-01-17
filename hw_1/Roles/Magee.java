package oop.hw_1.Roles;

import oop.hw_1.Hero;

abstract public class Magee extends Hero {
//    static private Random rand = new Random();


    public Magee(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY);
        initiative = 1;
    }
    @Override
    public String getTape() {
        return "Magee";
    }

    @Override
    protected boolean shoot() {
        return false;
    }

    @Override
    public boolean shoot(Hero other) {
        return false;
    }


}
