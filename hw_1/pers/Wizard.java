package oop.hw_1.pers;

import oop.hw_1.Roles.Magee;

public class Wizard extends Magee {
    public Wizard(String nameHero, int posX, int posY) {
        super(50, 50, 1, new int[]{15, 29}, nameHero, posX, posY);
//        rangeMaxDamage = 4;
    }

//    protected  int rangeMaxDamage;
//    protected Vector2 position;


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
