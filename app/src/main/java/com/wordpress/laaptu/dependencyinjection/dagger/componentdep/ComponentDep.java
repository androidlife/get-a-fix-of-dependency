package com.wordpress.laaptu.dependencyinjection.dagger.componentdep;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.dagger.DataComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.scope.CustomScope;
import dagger.Component;

/**
 * Created by laaptu on 9/29/16.
 */
@CustomScope
//If we define custom component
// this scope seems essential
//why? need to find out
@Component(modules = { StringModule.class }, dependencies = { DataComponent.class })
public interface ComponentDep {
  //remember in StringModule we request Context
  // if DataComponent doesn't give us Context
  // we are doomed
  // so check the DataComponent is providing us the Context
  // similarly if we want any other objects
  // of DataComponent to be used
  // dataComponent must declare it, then only
  // we can use those in our modules
  // or to our injected class
}
