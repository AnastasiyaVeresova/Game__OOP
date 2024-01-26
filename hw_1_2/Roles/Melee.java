package oop.hw_1_2.Roles;

import oop.hw_1_2.Hero;
import oop.hw_1_2.Vector2;

import java.util.ArrayList;
import java.util.Random;


abstract public class Melee extends Hero{
    static private Random rand = new Random();
    int step, damagePoint;

    public Melee(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int step) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 2);
        this.step = step;
    }

    public void getDamage(Hero target) {
        damagePoint = this.random.nextInt(damage[0], damage[1]);
        target.health = target.health - damagePoint;
        if (target.health < 0){
            target.health = 0;
        }
    }

    public Hero findBestEnemyMDD(ArrayList<Hero> enemys) {
        Hero heroTMP = null;
        for (int i = 0; i < enemys.size(); i++) {
            if (enemys.get(i).health>0) {
                if (heroTMP == null || this.position.rangeEnemy(enemys.get(i).position) < this.position.rangeEnemy(heroTMP.position)) {
                    heroTMP = enemys.get(i);
                }
            }
        }
        return heroTMP;

    }

    @Override
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if(isDead()) return;
        Hero tmpHero = findBestEnemyMDD(enemys);
        if (position.rangeEnemy(tmpHero.position) < 2) {
            getDamage(tmpHero);
            //System.out.println("Нанесен урон" + this.damagePoint);
        } else {
            Vector2 tmpVec = getStepMDD(tmpHero);
            boolean step = true;
            for (Hero hero : allies) {
                if (tmpVec.equals(hero.position) && hero.health>0) step = false;
            }
            if (step) position = tmpVec;
        }
    }
        public Vector2 getStepMDD(Hero enemy) {
            Vector2 delta = position.getDelta(enemy.position); //return new Vector2(posX - posEnemy.posX, posY - posEnemy.posY);
            Vector2 tmpVector2 = new Vector2(position.posX, position.posY);
            if (delta.posX < 0) {
                tmpVector2.posX++;
                return tmpVector2;
            }
            if (delta.posX > 0) {
                tmpVector2.posX--;
                return tmpVector2;
            }
            if (delta.posY < 0) {
                tmpVector2.posY++;
                return tmpVector2;
            }
            if (delta.posY > 0) {
                tmpVector2.posY--;
                return tmpVector2;
            }
            return tmpVector2;

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
    public String getType() {
        return "Пехота";
    }

}