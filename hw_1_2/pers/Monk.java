package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Magee;

public class Monk extends Magee {
    public Monk(String nameHero, int posX, int posY) {
        super(50, 50, 1, new int[]{-35, -30}, nameHero, posX, posY, 50, 50);
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;
//    protected Vector2 position;

    @Override
    public String toString() {
//        return ("Монах: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
        return ("Монах: " + super.toString());
    }

    @Override
    public String getInfo() {
        return "Монах";
    }




}
