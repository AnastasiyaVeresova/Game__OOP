package oop.hw_1.Roles;

import oop.hw_1.Hero;

import java.util.ArrayList;
import java.util.Random;


abstract public class Archer extends Hero{
    static private Random rand = new Random();
    protected int maxArrows = 70;

    public Archer(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY);
        initiative = 3;
    }

    @Override
    public boolean shoot(Hero other) {
        if( this.maxArrows >= 10){
            other.receiveDamage(rand.nextInt(damage[0],damage[1]));
            this.maxArrows -= 10;
            return true;
        }
        return false;

    }

    @Override
    protected boolean shoot() {
        return true;
    }

    public void receiveArrows(int amount){
        this.maxArrows += amount;
    }



    @Override
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if(this.isDead()) return;
        Hero other = nearestEnemy(enemys);
        if (!shoot(other)) {
            receiveArrows(4);
        };


    }
    @Override
    public String toString() {
        return super.toString() + "; стрелы: " + (Integer)(getArrows()/10);
    }


    @Override
    public String getTape() {
        return "Лучник";
    }

//    @Override
//    public int getHp() {
//        return super.getHp();
//    }

    public int getArrows() {
        return maxArrows;
    }
}
