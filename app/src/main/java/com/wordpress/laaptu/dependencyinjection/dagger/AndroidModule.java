package com.wordpress.laaptu.dependencyinjection.dagger;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

import static com.wordpress.laaptu.dependencyinjection.dagger.AndroidModule.PREF_NAME;

/**
 */
@Module public class AndroidModule {

  private Context context;
  public static final String PREF_NAME = "prefName";

  public AndroidModule(Context context) {
    this.context = context;
  }

  @Provides @Singleton public Context getContext() {
    return context;
  }

  @Provides @Named(PREF_NAME) public String getPrefName() {
    return "diPref";
  }
}

