package com.wordpress.laaptu.dependencyinjection.menu.coffee;

import timber.log.Timber;

/**
 * Created by laaptu on 4/25/17.
 */

public class Coffee {
    public enum Flavor {
        Americano, Espresso
    }

    public Flavor flavor = Flavor.Espresso;

    public Coffee(Flavor flavor) {
        this.flavor = flavor;
        Timber.d("Getting coffee with flavor = %s", getFlavor());
    }

    public String getFlavor() {
        switch (flavor) {
            case Americano:
                return "Americano";
            default:
                return "Espresso";
        }
    }
}
