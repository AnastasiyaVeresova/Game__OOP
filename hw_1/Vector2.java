package oop.hw_1;

import java.util.ArrayList;

public class Vector2 {
    int posX, posY;

    public Vector2(int posX, int posY) {

        this.posX = posX;
        this.posY = posY;

    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public boolean longestAxis(Vector2 posEnemy) {
        return Math.abs(posEnemy.posY - posY) > Math.abs(posEnemy.posX - posX);
    }

    public void moveX(Vector2 posEnemy, ArrayList<Hero> allies, boolean failed) {

        int delta = posEnemy.getX() - this.getX() < 0? -1:1;
        for (Hero h : allies) {
            if (h.getLocation().getY() == this.getY() && h.getLocation().getX() == this.getX() + delta) {
                if(failed) return;
                moveY(posEnemy, allies, true);
                return;
            }
        }
        this.posX += delta;
    }

    public void moveY(Vector2 posEnemy, ArrayList<Hero> allies, boolean failed) {
        int delta = posEnemy.getY() - this.getY() < 0? -1:1;
        for (Hero h : allies) {
            if (h.getLocation().getY() == this.getY() && h.getLocation().getX() == this.getX() + delta) {
                if(failed) return;
                moveY(posEnemy, allies, true);
                return;
            }
        }
        this.posY += delta;
    }


    @Override
    public String toString() {
        return "Position(" + posX + ", " + posY + "; " + (float) Math.sqrt(Math.pow(posX + posY, 2)) +")";
//          return "Position(" + posX + ", " + posY;

    }

    public float rangeEnemy(Vector2 posEnemy) {
        double distance = (Math.sqrt(Math.pow(posEnemy.posY - posY, 2) + Math.pow(posEnemy.posX - posX, 2)));

        return (float) distance;
    }
}