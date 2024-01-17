package oop.hw_1;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Hero {
    protected int health, healthMax, armor, initiative;
    protected Vector2 position;

    protected int[] damage;
    protected String nameHero;


    public Hero(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
        this.position = new Vector2(posX, posY);
    }

    public Vector2 getLocation() {
        return this.position;
    }

    public void printEnemyDistance(ArrayList<Hero> enemys) {
        System.out.print(nameHero + ": ");
        enemys.forEach(n -> System.out.print(position.rangeEnemy(n.position) + ", "));

        System.out.println();
        System.out.println("Ближайший противник: " + nearestEnemy(enemys) + ", на расстоянии: " + minDistance(enemys));

    }

    public float minDistance(ArrayList<Hero> enemys) {
        ArrayList<Float> dist = new ArrayList<>();
        float minDist = 0;
        for (Hero hero : enemys) {
            enemys.forEach(n -> dist.add(position.rangeEnemy(n.position)));
            minDist = Collections.min(dist);
        }
        return minDist;
    }

//    public Hero nearestEnemy(ArrayList<Hero> enemys) {
//        float minDistance = this.position.rangeEnemy(enemys.get(0).getLocation());
//        Hero hero = enemys.get(0);
//        for (int i = 0; i < enemys.size(); i++) {
//            if (this.position.rangeEnemy(enemys.get(i).position) < this.position.rangeEnemy(hero.position)) {
//                hero = enemys.get(i);
//            }
//        }
//        return hero;
//    }


    public Hero nearestEnemy(ArrayList<Hero> enemys) {
        float minDistance = this.position.rangeEnemy(enemys.get(0).getLocation());
        Hero hero = enemys.get(0);
        for(int i = 1; i< enemys.size();i++)
        {
            float distance = enemys.get(i).getLocation().rangeEnemy(this.getLocation());
            if (distance < minDistance && enemys.get(i).isDead()){
                minDistance = distance;
                hero = enemys.get(i);
            }
        }
        return hero;
    }

    @Override
    public String toString() {
//        return nameHero + "; здоровье: " + health + "/" + healthMax + "; броня: " + armor +"; X:" + this.getLocation().getX() + ", Y:" + this.getLocation().getY();
        return nameHero + "; здоровье: " + health + "/" + healthMax + "; броня: " + armor +"; X:" + this.getLocation().getX() + ", Y:" + this.getLocation().getY();

    }

    public String getName() {
        return this.nameHero;
    }

    protected abstract boolean shoot();

    public abstract String getTape();

    public void receiveDamage(int damage) {
        this.health -= (damage - this.armor);
        if (this.health < 1) {
            die();
        }
    }

    public void die() {
        System.out.println(this.nameHero + " is dead.");
        this.position.posX = -11;
        this.position.posY = -11;
    }

    public boolean isDead() {
        return this.health < 1;
    }


    public int getInitiative() {
        return initiative;
    }

    public abstract boolean shoot(Hero other);

    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        System.out.println("Not Implemented");
    }





}