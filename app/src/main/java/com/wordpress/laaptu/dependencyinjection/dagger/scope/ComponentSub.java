package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;
import dagger.Subcomponent;

/**
 */
@Subcomponent(modules = { ModuleSub.class }) public interface ComponentSub {
  void inject(FormDisplayFragment target);

  void inject(FormEditFragment target);
}
