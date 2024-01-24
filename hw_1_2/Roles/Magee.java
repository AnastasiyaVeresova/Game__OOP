package oop.hw_1_2.Roles;

import oop.hw_1_2.Hero;

import java.util.ArrayList;
import java.util.Random;

abstract public class Magee extends Hero {
    static private Random rand = new Random();

    int mana, manaMax, healingPoint, manaCost;
    int manaRes = 8;
    boolean flagRes = false;
    public Magee(int health, int healthMax, int armor, int[] damage, String nameHero, int posX, int posY, int mana, int manaMax) {
        super(health, healthMax, armor, damage, nameHero, posX, posY, 1);
        this.mana = mana;
        this.manaMax = manaMax;
    }
    public void getResp(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if (!flagRes && random.nextInt(0,5) != 4){
            return;
        }
        manaCost = manaMax / 2;
        if (enemys.stream().allMatch(n -> !n.getType().equals("Melee") || n.health < 1)) {
            flagRes = true;
            if(this.mana < manaMax) return;
            for (Hero h : allies) {
                if (h.getType().equals("Melee")) {
                    for (Hero enemy : enemys) {
                        if (h.position.rangeEnemy(enemy.position) == 0) {
                            return;
                        }
                    }
                    for (Hero alliesOne : allies) {
                        if (h.position.rangeEnemy(alliesOne.position) == 0) {
                            return;
                        }
                    }
                    h.health = h.healthMax;
                    this.mana -= manaCost;
                    flagRes = false;
                    return;
                }
            }
        }
    }

    public Hero findMinHealthAllies(ArrayList<Hero> allies) {
        Hero heroTMP = allies.get(0);
        for (Hero ally : allies) {
            if (heroTMP.health > ally.health && ally.health > 0) {
                heroTMP = ally;
            }
        }
        return heroTMP;
    }

    public void getHealing(oop.hw_3.Hero target) {
        manaCost = 10;
        if (this.mana >= manaCost) {
            if (target.health > 0 && target.health < target.healthMax) {
                healingPoint = this.random.nextInt(damage[0], damage[1]);
                target.health = target.health + healingPoint;
                if (target.health > target.healthMax) {
                    target.health = target.healthMax;
                }
            }
            this.mana -= manaCost;
        }
    }

    @Override
    public String getType() {
        return "Маги";
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
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys){
        if(this.health < 1) return;
        getResp(allies, enemys);
        if (!flagRes){
            heal(findMinHealthAllies(allies));
        }
        this.mana += manaRes;
        if (mana > manaMax) {
            mana = manaMax;
        }
    }



    public void heal(Hero order) {
        manaCost = 10;
        if (this.mana >= manaCost) {
            if (order.health > 0 && order.health < order.healthMax) {
                healingPoint = this.random.nextInt(damage[0], damage[1]);
                order.health = order.health + healingPoint;
                if (order.health > order.healthMax) {
                    order.health = order.healthMax;
                }
            }
            this.mana -= manaCost;
        }
    }




}
