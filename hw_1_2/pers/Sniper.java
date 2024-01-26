package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Archer;

public class Sniper extends Archer {
    public Sniper(String nameHero, int posX, int posY) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY, 0, 7, 4);
        angryRDD = new Rogue(this.nameHero, this.position.posX, this.position.posY);
        angryRDD.position = this.position;
        angryRDD.damage = new int[] {9, 10};
    }


    @Override
    public String toString() {
        return ("Снайпер: " + super.toString());
    }
    @Override
    public String getInfo() {
        return "Снайпер";
    }

}
