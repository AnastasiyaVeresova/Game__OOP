package oop.hw_1_2.Interfaces;

import oop.hw_1_2.Hero;

import java.util.ArrayList;

public abstract interface Step {
    void step(ArrayList<Hero> allies, ArrayList<Hero> enemys);
}
