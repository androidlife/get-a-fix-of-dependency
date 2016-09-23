package com.wordpress.laaptu.dependencyinjection.dagger;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 */

@Module public class DataModule {

  //@Provides @Singleton
  //public DataService getDataService(@Named(AndroidModule.PREF_NAME) String prefName,
  //    Context context) {
  //  return new PrefManager(context, prefName);
  //}

  @Provides @Singleton public DataService getDataService(Context context) {
    return new DbManager(context);
  }
}
