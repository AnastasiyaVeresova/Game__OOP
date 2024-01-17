package oop.hw_1.Roles;

import oop.hw_1.Hero;

import java.util.ArrayList;
import java.util.Random;


abstract public class Archer extends Hero{
    static private Random rand = new Random();
    private int maxArrows = 50;

    public Archer(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY);
        initiative = 3;
    }

    @Override
    public boolean shoot(Hero other) {
        if( this.maxArrows >= 3){
            other.receiveDamage(rand.nextInt(damage[0],damage[1]));
            this.maxArrows -= 1;
            return true;
        }
        System.out.println("Out of Ammo");
        return false;

    }

    @Override
    protected boolean shoot() {
        return false;
    }

    public void receiveArrows(int amount){
        this.maxArrows += amount;
    }

    public int getAArrows(){
        return maxArrows;
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
        return super.toString() + "; Arrows: " + (Integer)(getAArrows()/10);
    }


    @Override
    public String getTape() {
        return "Archer";
    }
}
