package com.wordpress.laaptu.dependencyinjection.dagger;

import com.wordpress.laaptu.dependencyinjection.MainActivity;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;
import dagger.Component;

/**
 * This component links
 * DataModule ( where we have
 * defined way to instantiate
 * dependent object DataService )
 * and dependent classes which are
 * MainActivity,FormDisplayFragment
 * and FormEditFragment).
 */
@Component(modules = { DataModule.class }) public interface DataComponent {
  /**
   * If component only knows about module
   * and not the dependent classes, then
   * there is no way for dependent classes
   * to use the dependency object. So
   * the following method act as link
   * between component and dependent classes.
   * This link enables the dependent classes
   * to use the dependency object or DataService
   * object
   */
  void inject(MainActivity target);

  void inject(FormDisplayFragment target);
  /**
   * This is just a method definition.
   * So you can name it whatever you like.
   * But try to make it meaningful as well
   */
  void injecto(FormEditFragment target);
}
