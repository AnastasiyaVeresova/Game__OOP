package oop.hw_1_2.pers;

import oop.hw_1_2.Hero;
import oop.hw_1_2.Roles.Archer;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends Hero {
    static  private Random rand = new Random();
    public Peasant(String nameHero, int posX, int posY) {
        super(100, 100, 0, new int[]{0, 0}, nameHero, posX, posY,0);

//        rangeMaxDamage = 4;
    }
    public void getArrow(Hero target) {
        if (target == null) {
            return;
        }
        if (((Archer) target).quantityShots < ((Archer) target).quantityShotsMax) {
            ((Archer) target).quantityShots++;
        }
    }

//    protected  int rangeMaxDamage;
//    protected Vector2 position;

    @Override
    public String toString() {
        return ("Крестьянин: "  + super.toString());
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
        return ("Крестьянин: " + super.toString());
    }

    @Override
    public String getInfo() {
        return "Крестьянин";
    }


    @Override
    public void giveArrows(Archer hero) {
        int numGiven = rand.nextInt(this.damage[0], damage[1]);
        hero.receiveArrows(numGiven);
        System.out.println(this.nameHero + "передача" + hero.getName() + " " + (float) numGiven / 10 + "стрел");
    }
    public Hero findMoreEmptyRDD(ArrayList<Hero> allies) {
        ArrayList<Archer> rdd = new ArrayList<>();
        for (Hero hero : allies) {
            if (hero instanceof Archer && hero.health > 0) {
                rdd.add((Archer) hero);
            }
        }
        Archer rddTMP = null;
        if (!rdd.isEmpty()) {
            rddTMP = rdd.get(0);
            for (Archer hero : rdd) {
                if (rddTMP.quantityShots > hero.quantityShots) {
                    rddTMP = hero;
                }
            }
        }
        return rddTMP;
    }
    @Override
    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
        if(isDead()) return;
        getArrow(findMoreEmptyRDD(allies));

    }


//    @Override
//    public void step(ArrayList<Hero> allies, ArrayList<Hero> enemys) {
//        if(isDead()) return;
//        Archer hero = null;
//        int minArrows = Integer.MAX_VALUE;
//        for(Hero h: allies) {
//            if (h.isDead()) continue;
//            if (((Archer)(h)).getArrows() < minArrows) {
//                hero = (Archer) h;
//                minArrows = hero.getArrows();
//            }
//        }
//        if (hero != null) giveArrows(hero);
//    }


}