package com.wordpress.laaptu.dependencyinjection.dagger;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import dagger.Module;
import dagger.Provides;

/**
 * @Module means this is module container
 * this container is looked upon on how to
 * instantiate any dependent object.
 * There can be many modules and
 * each module can define any number of
 * dependency objects as per need.
 */

@Module public class DataModule {

  private Context context;
  private static final String PREF_NAME = "diPref";

  public DataModule(Context context) {
    this.context = context;
  }

  /**
   * @Provides means it is providing some objects
   * or it is stub where we define how to
   * instantiate dependency object.
   * Further both our DataService( Preference
   * or Database) needs context in
   * their constructor.
   * So you need to pass the context to
   * this class or provide a context in
   * any other way.
   * Meaning it won't automatically search for
   * context.*/
  @Provides public DataService getDataService() {
    //return getPreferenceDataService();
    //OR
    return getDatabaseDataService();
  }

  private DataService getPreferenceDataService() {
    return PrefManager.getInstance(context, PREF_NAME);
  }

  private DataService getDatabaseDataService() {
    return DbManager.getInstance(context);
  }
}
