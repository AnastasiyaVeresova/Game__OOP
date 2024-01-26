package oop.hw_1_2;

import oop.hw_1_2.Interfaces.Step;
import oop.hw_1_2.Roles.Archer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Hero implements Step {
    public int health, healthMax, armor, initiative;
    public Random random = new Random();
    public Vector2 position;
    public int[] damage;
    public String nameHero;


    public Hero(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int initiative) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
        this.position = new Vector2(posX, posY);
        this.initiative = initiative;
    }

    public Vector2 getLocation() {
        return this.position;
    }

    public void printEnemyDistance(ArrayList<Hero> enemys) {
        System.out.print(nameHero + ": ");
        enemys.forEach(n -> System.out.print(position.rangeEnemy(n.position) + ", "));

        System.out.println();
//        System.out.println("Ближайший противник: " + nearestEnemy(enemys) + ", на расстоянии: " + minDistance(enemys));

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

    public abstract String getType();

    public void receiveDamage(int damage) {
        this.health -= (damage - this.armor);
        if (this.health < 1) {
//        System.out.println(this.nameHero + " is dead.");
            this.health = 0;
        }
    }

    public boolean isDead() {
        return health < 1;
    }


    public int getInitiative() {
        return initiative;
    }

    public abstract boolean shoot(Hero other);


    public void giveArrows(Archer hero){


    };



    public int[] getCoords() {
        return new int[]{position.posX, position.posY};
    }


    public abstract String getInfo();


    public int getHp() {
        return health;
    }

    public void getHeal (int mana) {
        this.health += mana;
        if (this.health < this.healthMax)
            this.health = this.healthMax;
    }

    public boolean isInjured() {
        return this.health >= 1 && this.health < this.healthMax;
    }




}