package oop.hw_3.Interfaces;

import oop.hw_3.Hero;

import java.util.ArrayList;

public interface GameI {
    void gameStep(ArrayList<Hero> teamEnemy, ArrayList<Hero> teamAllias);
    //void gameStep(ArrayList<Hero> teamEnemy);

}