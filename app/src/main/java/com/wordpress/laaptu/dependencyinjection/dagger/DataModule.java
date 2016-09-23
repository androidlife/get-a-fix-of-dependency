package com.wordpress.laaptu.dependencyinjection.dagger;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import dagger.Module;
import dagger.Provides;

/**
 */

@Module public class DataModule {

  private Context context;
  private static final String PREF_NAME = "diPref";

  public DataModule(Context context) {
    this.context = context;
  }

  @Provides public DataService getDataService() {
    //return PrefManager.getInstance(context, PREF_NAME);
    return DbManager.getInstance(context);
  }
}
