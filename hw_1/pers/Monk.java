package oop.hw_1.pers;

import oop.hw_1.Roles.Magee;

public class Monk extends Magee {
    public Monk(String nameHero, int posX, int posY) {
        super(50, 50, 1, new int[]{-35, -30}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;
    @Override
    public String toString() {
//        return ("Монах: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
        return ("Monk: " + super.toString());
    }




}
