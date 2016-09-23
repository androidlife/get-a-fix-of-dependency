package com.wordpress.laaptu.dependencyinjection.mock;

import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.dagger.DataComponent;
import com.wordpress.laaptu.dependencyinjection.mock.dagger.DaggerMockDataComponent;
import com.wordpress.laaptu.dependencyinjection.mock.dagger.MockDataModule;

/**
 */

public class MockMainApplication extends MainApplication {
  @Override protected DataComponent createDataComponent() {
    return DaggerMockDataComponent.builder().mockDataModule(new MockDataModule()).build();
  }
}
