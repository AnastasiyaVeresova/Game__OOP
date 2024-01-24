package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Melee;

public class Pikeman extends Melee {

    public Pikeman(String nameHero, int posX, int posY) {
        super(100, 100, 5, new int[]{20, 30}, nameHero, posX, posY, 1);
//        rangeMaxDamage = 4;
    }


    @Override
    public String toString() {
//        return ("Копейщик: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
        return ("Копейщик: " + super.toString());
    }
//    protected Vector2 position;

    @Override
    public String getInfo() {
        return "Копейщик";
    }




}