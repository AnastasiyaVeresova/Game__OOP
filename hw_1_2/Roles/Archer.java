package oop.hw_1_2.Roles;

import oop.hw_1_2.Hero;

import java.util.ArrayList;
import java.util.Random;


abstract public class Archer extends Hero{
    static private Random rand = new Random();
    public int quantityShotsMax;
    public int quantityShots;
    int rangeMaxDamage;
    public Hero angryRDD = null;


    protected int maxArrows = 70;

    public Archer(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int quantityShots, int quantityShotsMax, int rangeMaxDamage) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 3);
        this.quantityShots = quantityShots;
        this.quantityShotsMax = quantityShotsMax;
        this.rangeMaxDamage = rangeMaxDamage;
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

    public Hero findBestEnemyRDD(ArrayList<Hero> enemys) { //дописать проверку на жизнь
        Hero heroTMP = enemys.get(0);
        for (int i = 0; i < enemys.size(); i++) {
            if (heroTMP.health < 1) {
                heroTMP = enemys.get(i);
            }
            if (this.position.rangeEnemy(enemys.get(i).position) < this.position.rangeEnemy(heroTMP.position)) {
                heroTMP = enemys.get(i);
            }
        }
        if (this.position.rangeEnemy(heroTMP.position) > this.rangeMaxDamage) {
            for (Hero enemy : enemys) {
                if (heroTMP.health > enemy.health) {
                    heroTMP = enemy;
                }
            }
        }
        return heroTMP;
    }


    @Override
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if(this.health < 1) return;
        if (this.quantityShots == 0) {
            this.angryRDD.health = health;
            this.angryRDD.step(enemys, allies);
            this.position = angryRDD.position;
            return;
        }
        Hero target = findBestEnemyRDD(enemys);
        target.receiveDamage((this.position.rangeEnemy(target.position) < rangeMaxDamage)? this.random.nextInt(damage[0], damage[1]): damage[0]);
        quantityShots--;
    }

    @Override
    public String toString() {
        return super.toString() + "; стрелы: " + (Integer)(getArrows()/10);
    }


    @Override
    public String getType() {
        return "Лучник";
    }

    public int getArrows() {
        return maxArrows;
    }
}
