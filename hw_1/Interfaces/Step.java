package oop.hw_1.Interfaces;

import oop.hw_1.Hero;

import java.util.ArrayList;

public abstract interface Step {
    void step(ArrayList<Hero> allies, ArrayList<Hero> enemys);
}
