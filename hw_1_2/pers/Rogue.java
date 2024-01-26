package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Melee;

public class Rogue extends Melee {
    public Rogue(String nameHero, int posX, int posY) {
        super(100, 100, 5, new int[]{20, 30}, nameHero, posX, posY, 1);
//        rangeMaxDamage = 4;
    }

    @Override
    public String toString() {
        return ("Разбойник: " + super.toString());
    }
    @Override
    public String getInfo() {
        return "Разбойник";
    }
}
