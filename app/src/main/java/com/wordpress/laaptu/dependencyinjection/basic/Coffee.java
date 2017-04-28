package com.wordpress.laaptu.dependencyinjection.basic;

/**
 * Created by laaptu on 4/25/17.
 */

public class Coffee {
    public enum Flavor {
        Latte, Americano, Espresso
    }

    public Flavor flavor = Flavor.Espresso;

    public Coffee(Flavor flavor) {
        this.flavor = flavor;
    }
}
