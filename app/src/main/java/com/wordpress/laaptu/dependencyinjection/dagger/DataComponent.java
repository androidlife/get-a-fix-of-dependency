package com.wordpress.laaptu.dependencyinjection.dagger;

import com.wordpress.laaptu.dependencyinjection.MainActivity;
import com.wordpress.laaptu.dependencyinjection.dagger.scope.ComponentSub;
import com.wordpress.laaptu.dependencyinjection.dagger.scope.ModuleSub;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;
import dagger.Component;
import javax.inject.Singleton;

/**
 */
@Singleton @Component(modules = { DataModule.class, AndroidModule.class })
public interface DataComponent {
  void inject(MainActivity target);

  ComponentSub addSubComponent(ModuleSub subModule);
}
