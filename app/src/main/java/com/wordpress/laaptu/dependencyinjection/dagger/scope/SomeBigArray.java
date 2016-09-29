package com.wordpress.laaptu.dependencyinjection.dagger.scope;

/**
 */

public class SomeBigArray {
  private String[] bigArr;

  public SomeBigArray() {
    bigArr = new String[1000];
    for (int i = 0; i < 1000; ++i)
      bigArr[i] = String.valueOf(i);
  }
}
