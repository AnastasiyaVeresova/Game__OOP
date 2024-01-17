package oop.hw_1.pers;

import oop.hw_1.Roles.Melee;

public class Rogue extends Melee {
    public Rogue(String nameHero, int posX, int posY) {
        super(100, 100, 5, new int[]{20, 30}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;

    @Override
    public String toString() {
//        return ("Разбойник: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
        return ("Rogue: " + super.toString());
    }


}
