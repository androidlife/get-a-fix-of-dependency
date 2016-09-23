package com.wordpress.laaptu.dependencyinjection.mock.dagger;

import com.wordpress.laaptu.dependencyinjection.data.DataService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.mockito.Mockito;

@Module public class MockDataModule {
  @Provides @Singleton public DataService getDataService() {
    return Mockito.mock(DataService.class);
  }
}
