package com.wordpress.laaptu.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import com.wordpress.laaptu.dependencyinjection.events.BusProvider;
import com.wordpress.laaptu.dependencyinjection.events.Events;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragmentPref;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragmentPref;
import com.wordpress.laaptu.dependencyinjection.model.User;

import static com.wordpress.laaptu.dependencyinjection.model.User.getUser;

public class MainActivityPref extends AppCompatActivity {

  Toolbar toolbar;

  private static final String FRAG_EDIT = "FormEditFragmentPref", FRAG_DISPLAY =
      "FormDisplayFragmentPref";

  public enum FragState {
    Edit, Display;
  }

  private FragState fragState;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
    identifyState();
  }

  private void identifyState() {
    User user = getUser();
    if (user == null) {
      changeFragment(FragState.Edit);
    } else {
      changeFragment(FragState.Display);
    }
  }

  private void changeFragment(FragState fragState) {
    if (this.fragState != null && this.fragState == fragState) return;
    this.fragState = fragState;
    switch (fragState) {
      case Edit:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, FormEditFragmentPref.getInstance(null), FRAG_EDIT)
            .commit();
        break;
      case Display:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, FormDisplayFragmentPref.getInstance(null), FRAG_DISPLAY)
            .commit();
        break;
    }
    invalidateOptionsMenu();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    if (this.fragState != null) {
      if (fragState == FragState.Edit) {
        menu.findItem(R.id.menu_edit).setVisible(false);
        menu.findItem(R.id.menu_save).setVisible(true);
      } else {
        menu.findItem(R.id.menu_edit).setVisible(true);
        menu.findItem(R.id.menu_save).setVisible(false);
      }
    }
    return super.onCreateOptionsMenu(menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_edit:
        toggleFragment(null);
        break;
      case R.id.menu_save:
        BusProvider.getEventBus().postEvent(new Events.EventSave());
        break;
    }
    return true;
  }

  @Subscribe public void toggleFragment(Events.EventToggle event) {
    if (fragState == null) return;
    FragState newState = (fragState == FragState.Edit) ? FragState.Display : FragState.Edit;
    changeFragment(newState);
  }

  @Override protected void onPause() {
    super.onPause();
    BusProvider.getEventBus().unregister(this);
  }

  @Override protected void onResume() {
    super.onResume();
    BusProvider.getEventBus().register(this);
  }

  private User getUser() {
    return PrefManager.getInstance(this, PrefManager.PREF_NAME).getUser();
  }
}
