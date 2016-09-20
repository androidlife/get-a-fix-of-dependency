package com.wordpress.laaptu.dependencyinjection;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import com.wordpress.laaptu.dependencyinjection.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 */
@RunWith(AndroidJUnit4.class) public class PrefManagerTest {
  @Rule public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  private PrefManager prefManager;

  @Before public void setPrefManager() {
    prefManager =
        PrefManager.getInstance(mainActivityActivityTestRule.getActivity().getApplicationContext(),
            PrefManager.PREF_NAME);
  }

  @After public void removeAllPrefValues() {
    prefManager.removeAll();
  }

  @Test public void storeAndFetchUser() {
    User user = prefManager.getUser();
    assertEquals(null, user);
    prefManager.storeUser(User.getUser());
    user = prefManager.getUser();
    assertEquals(user.toString(), User.getUser().toString());
  }
}
