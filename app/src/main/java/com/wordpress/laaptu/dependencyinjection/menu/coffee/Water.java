package com.wordpress.laaptu.dependencyinjection.menu.coffee;

/**
 * Created by laaptu on 4/25/17.
 */

public class Water {
    public int quantity;
    private boolean isHeated = false;

    public Water(int quantity) {
        this.quantity = quantity;
    }

    public void heat() {
        this.isHeated = true;
    }

    public boolean isWaterHot() {
        return isHeated;
    }
}
