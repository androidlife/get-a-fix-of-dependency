package com.wordpress.laaptu.dependencyinjection.dagger.componentdep;

import android.content.Context;
import com.wordpress.laaptu.dependencyinjection.R;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by laaptu on 9/29/16.
 */
@Module public class StringModule {
  @Provides @Named("AppName") public String getAppName(Context context) {
    return context.getString(R.string.app_name);
  }
}
