package oop.hw_1.pers;

import oop.hw_1.Roles.Archer;

public class Sniper extends Archer {
    public Sniper(String nameHero, int posX, int posY) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;

    @Override
    public String toString() {
        return ("Снайпер: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
    }
}
