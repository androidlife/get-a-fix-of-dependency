package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 9/28/16.
 */
@Module public class ModuleSub {
  /**
   * This can't be singleton as
   * now it lives in the scope of CustomScope*/
  @Provides public RandomString getRandomString() {
    return new RandomString();
  }
}
