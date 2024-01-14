package oop.hw_1.Roles;

import oop.hw_1.Hero;
import oop.hw_1.Interfaces.Shoot;
import oop.hw_1.Interfaces.Step;

import java.util.ArrayList;
import java.util.Random;


abstract public class Archer extends Hero implements Shoot, Step {
    static private Random rand = new Random();
    private int maxArrows;

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

    public void receiveAmmo(int amount){
        this.maxArrows += amount;
    }


    @Override
    public void step(ArrayList<Hero> enemys) {
        if(this.health < 1) return;
        Hero other = nearestEnemy(enemys);
        if (shoot(other)) {
            receiveAmmo(10);
        };


    }
}
