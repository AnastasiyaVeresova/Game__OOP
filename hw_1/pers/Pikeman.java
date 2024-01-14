package oop.hw_1.pers;

import oop.hw_1.Hero;
import oop.hw_1.Roles.Melee;

public class Pikeman extends Melee {

    public Pikeman(String nameHero, int posX, int posY) {
        super(100, 100, 5, new int[]{20, 30}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

    @Override
    public String toString() {
        return ("Копейщик: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
//        return ("Копейщик: " + super.toString());
    }


    @Override
    public boolean shoot(Hero other) {
        return false;
    }


}