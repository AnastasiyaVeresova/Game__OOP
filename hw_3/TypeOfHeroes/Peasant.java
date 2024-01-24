package oop.hw_3.TypeOfHeroes;

import oop.hw_3.Hero;
import oop.hw_3.Vector2;

import java.util.ArrayList;

/**
 * Описание структуры класса
 * Класс, описывающий тип героев, предоставляющий РДД боеприпасы
 * <p>
 * Методы:
 * getArrow - метод передачи стрел союзному РДД
 */
public class Peasant extends Hero {

    public Peasant(String nameHero, int posX, int posY) {
        super(100, 100, 0, new int[]{0, 0}, nameHero, posX, posY, 0);
    }

    protected Vector2 position;

    @Override
    public String toString() {
        return ("Крестьянин: " + nameHero + " здоровье: " + health + "/" + healthMax + " броня: " + armor);
    }


    public void getArrow(Hero target) {
        if (target == null) {
            return;
        }
        if (((RangeHero) target).quantityShots < ((RangeHero) target).quantityShotsMax) {
            ((RangeHero) target).quantityShots++;
        }
    }

    public Hero findMoreEmptyRDD(ArrayList<Hero> allies) {
        ArrayList<RangeHero> rdd = new ArrayList<>();
        for (Hero hero : allies) {
            if (hero instanceof RangeHero && hero.health > 0) {
                rdd.add((RangeHero) hero);
            }
        }
        RangeHero rddTMP = null;
        if (!rdd.isEmpty()) {
            rddTMP = rdd.get(0);
            for (RangeHero hero : rdd) {
                if (rddTMP.quantityShots > hero.quantityShots) {
                    rddTMP = hero;
                }
            }
        }
        return rddTMP;
    }

    @Override
    public void gameStep(ArrayList<Hero> teamEnemy, ArrayList<Hero> teamAllies) {
        if (this.health > 0) {
            getArrow(findMoreEmptyRDD(teamAllies));
        }
    }

    @Override
    public String getInfo() {
        return "Крестьянин";
    }

    @Override
    public String getType() {
        return "Peasant";
    }
}