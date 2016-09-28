package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import java.util.Random;

/**
 */

public class RandomString {
  public String someRandomString;

  public RandomString() {
    someRandomString = String.valueOf(new Random().nextInt() * 1000);
    System.out.println("someRandomString value = " + someRandomString);
  }
}
