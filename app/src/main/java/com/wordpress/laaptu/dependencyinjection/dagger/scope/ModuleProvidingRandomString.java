package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;


@Module public class ModuleProvidingRandomString {
  @Provides @Singleton public SomeRandomString getSomeRandomString() {
    return new SomeRandomString();
  }
}
