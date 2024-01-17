package oop.hw_1.Roles;

import oop.hw_1.Hero;
import oop.hw_1.Interfaces.Hit;
import oop.hw_1.Interfaces.Step;

import java.util.ArrayList;
import java.util.Random;


abstract public class Melee extends Hero implements Hit, Step {
    static private Random rand = new Random();

    public Melee(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        super(health, healthMax, armor, damage, nameHero, posX, posY);
        initiative = 2;
    }
    @Override
    public boolean hit(Hero other) {
        if (other.isDead()) return false;
        other.receiveDamage(rand.nextInt(damage[0],damage[1]));
        return true;

    }
    @Override
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if(isDead()) return;
        Hero enemy = nearestEnemy(enemys);
        if(this.getLocation().rangeEnemy(enemy.getLocation())<= Math.sqrt(2)){
            hit(enemy);
            return;
        }
        if(getLocation().longestAxis(enemy.getLocation())){
            this.getLocation().moveY(enemy.getLocation(),allies,false);
        }
        else{
            this.getLocation().moveX(enemy.getLocation(),allies,false);
        }

    }

    @Override
    protected boolean shoot() {
        return false;
    }

    @Override
    public boolean shoot(Hero other) {
        return false;
    }

    @Override
    public String getTape() {
        return "Melee";
    }
}