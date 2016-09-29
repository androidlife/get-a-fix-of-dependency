package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by laaptu on 9/28/16.
 */
@Module public class ModuleSub {
  /**
   * This can't be singleton as
   * now it lives in the scope of CustomScope
   */
  @Provides @Named("forFormDisplayFragment") public RandomString getRandomString() {
    return new RandomString();
  }

  @Provides @Named("forFormEditFragment") public RandomString getRandomString1() {
    RandomString randomString = new RandomString();
    randomString.someRandomString += "forFormEditFragment";
    return randomString;
  }

  @Provides public SomeBigArray getBigArr() {
    return new SomeBigArray();
  }
}
