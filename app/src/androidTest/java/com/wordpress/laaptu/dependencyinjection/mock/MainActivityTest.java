package com.wordpress.laaptu.dependencyinjection.mock;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.wordpress.laaptu.dependencyinjection.MainActivity;
import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.mock.dagger.MockDataComponent;
import com.wordpress.laaptu.dependencyinjection.model.User;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.atLeastOnce;

/**
 */
@RunWith(AndroidJUnit4.class) public class MainActivityTest {
  @Rule public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
      new ActivityTestRule<>(MainActivity.class, true, false);
  @Inject DataService dataService;

  @Before public void setUp() {
    Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    MainApplication mainApplication =
        (MainApplication) instrumentation.getTargetContext().getApplicationContext();
    MockDataComponent mockDataComponent = (MockDataComponent) mainApplication.getDataComponent();
    mockDataComponent.inject(this);
  }

  @Test public void mockDataServiceTest() {
    User user = new User();
    user.name = "Tom Cruise";
    user.phone = "9901054678";
    user.email = "tom@cruise.com";
    user.address = " Orange County, LA, Beverly Hills";

    Mockito.when(dataService.getUser()).thenReturn(user);
    mainActivityActivityTestRule.launchActivity(new Intent());

    Mockito.verify(dataService,atLeastOnce()).getUser();
  }
}
