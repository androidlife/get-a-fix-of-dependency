package com.wordpress.laaptu.dependencyinjection.mock.dagger;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.dagger.DataComponent;
import com.wordpress.laaptu.dependencyinjection.mock.MainActivityTest;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by laaptu on 9/23/16.
 */
@Singleton @Component(modules = { MockDataModule.class }) public interface MockDataComponent extends
    DataComponent {
  void inject(MainActivityTest target);

}
