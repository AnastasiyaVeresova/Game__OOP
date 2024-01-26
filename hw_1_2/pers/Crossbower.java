package oop.hw_1_2.pers;

import oop.hw_1_2.Roles.Archer;
import oop.hw_3.Vector2;

public class Crossbower extends Archer {

    float minDist;

    public Crossbower(String nameHero, int posX, int posY, float minDist) {
        super(75, 75, 2, new int[]{10, 15}, nameHero, posX, posY, 0, 7, 4);
//        rangeMaxDamage = 4;
        this.minDist = minDist;
        Vector2 position;
        angryRDD = new Pikeman(this.nameHero, this.position.posX, this.position.posY);
        angryRDD.position = this.position;
        angryRDD.damage = new int[] {9, 10};
    }
//    protected Vector2 position;

    @Override
    public String toString() {
        return ("Арбалетчик: " + super.toString());
    }

    @Override
    public String getInfo() {
        return "Арбалетчик";
    }

}