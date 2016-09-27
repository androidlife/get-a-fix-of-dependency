package com.wordpress.laaptu.dependencyinjection;

import android.app.Application;
import com.wordpress.laaptu.dependencyinjection.dagger.DaggerDataComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DataComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DataModule;

/**
 */

public class MainApplication extends Application {
  private DataComponent dataComponent;

  @Override public void onCreate() {
    super.onCreate();
    /**
     * This part may be confusing
     * at first.
     * If you at first simply write this
     * line, the IDE would throw error as
     * these classes won't be built until
     * and unless you go to Build->RebuildProject.
     * Once you do that, go to
     * app/build/generated/source/apt/...
     * You will see these generated class
     * and it won't throw any error on IDE.
     * DataComponent= name of our component.
     * Dagger by default create the component as
     * DaggerDataComponent
     * dataModule() method simply means your are
     * trying to use DataModule class as defined
     * in the @Component(modules = { DataModule.class }).
     * So if there is another module named HelloModule
     * and being used by the DataComponent, there
     * will be method named
     * helloModule().
    */
    dataComponent = DaggerDataComponent.builder()
        .dataModule(new DataModule(this)).build();
    /**
     * @Component(modules = { DataModule.class }),
     * simply creates a
     * setter in DaggerDataComponent class as
     * dataModule(DataModule dataModule). Look
     * upon the generated class. If you don't set
     * the DataModule, it will be null i.e. if you won't
     * do as above statement, DataComponent will be created
     * but with null dataModule. So annotating and
     * setting the module is both need for component
     * to function properly
     */
  }

  public DataComponent getDataComponent() {
    return dataComponent;
  }
}
