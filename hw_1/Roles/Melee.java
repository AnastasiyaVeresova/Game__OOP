package oop.hw_1.Roles;

import oop.hw_1.Hero;

abstract public class Melee extends Hero {
    public Melee(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY);
        initiative = 2;
    }
}
