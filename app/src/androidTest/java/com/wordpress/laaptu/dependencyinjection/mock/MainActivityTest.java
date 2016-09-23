package com.wordpress.laaptu.dependencyinjection.mock;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.wordpress.laaptu.dependencyinjection.MainActivity;
import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.mock.dagger.MockDataComponent;
import com.wordpress.laaptu.dependencyinjection.model.User;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
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

    Mockito.verify(dataService, atLeastOnce()).getUser();
    onView(withId(R.id.menu_edit)).check(matches(isDisplayed()));
    onView(withId(R.id.menu_edit)).perform(click());
    onView(withId(R.id.menu_save)).check(matches(isDisplayed()));
    onView(withId(R.id.menu_save)).perform(click());
    ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
    Mockito.verify(dataService).storeUser(argument.capture());
    assertEquals(user.toString(), argument.getValue().toString());
  }
}
