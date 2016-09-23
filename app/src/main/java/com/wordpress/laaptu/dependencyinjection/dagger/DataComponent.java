package com.wordpress.laaptu.dependencyinjection.dagger;

import com.wordpress.laaptu.dependencyinjection.MainActivity;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;
import dagger.Component;

/**
 */
@Component(modules = { DataModule.class }) public interface DataComponent {
  void inject(MainActivity target);

  void inject(FormDisplayFragment target);

  void inject(FormEditFragment target);
}
