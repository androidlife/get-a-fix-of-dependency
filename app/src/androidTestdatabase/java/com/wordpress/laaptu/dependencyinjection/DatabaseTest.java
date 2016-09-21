package com.wordpress.laaptu.dependencyinjection;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class) public class DatabaseTest {

  @Rule public ActivityTestRule<MainActivityDb> mainActivityActivityTestRule =
      new ActivityTestRule<>(MainActivityDb.class);

  private DbManager dbManager;

  @Before public void initDatabase() {
    dbManager =
        DbManager.getInstance(mainActivityActivityTestRule.getActivity().getApplicationContext());
  }

  @After public void closeDatabase() {
    dbManager.closeDatabase();
  }

  @Test public void fetchAndStoreUserTest() {
    User user = dbManager.getUser();
    assertEquals(null, user);
    dbManager.storeUser(User.getUser());
    user = dbManager.getUser();
    assertEquals(user.toString(), User.getUser().toString());
  }
}