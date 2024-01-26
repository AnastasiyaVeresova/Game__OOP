package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Magee;

public class Wizard extends Magee {
    public Wizard(String nameHero, int posX, int posY) {
        super(50, 50, 1, new int[]{15, 29}, nameHero, posX, posY, 50, 50);
    }

    @Override
    public String toString() {
//        return ("Колдун: " + nameHero + ", здоровье: " + health + "/" + healthMax + ", броня: " + armor);
        return ("Колдун: " + super.toString());
    }
    @Override
    public String getInfo() {
        return "Колдун";
    }
}
