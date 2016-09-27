package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import java.util.Random;

/**
 */

public class SomeRandomString {
  public String someRandomString;

  public SomeRandomString() {
    someRandomString = String.valueOf(new Random().nextInt() * 1000);
    System.out.println("someRandomString value = " + someRandomString);
  }
}
