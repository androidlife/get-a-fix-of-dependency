package com.wordpress.laaptu.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.wordpress.laaptu.dependencyinjection.fragments.FormDisplayFragment;
import com.wordpress.laaptu.dependencyinjection.fragments.FormEditFragment;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;

  private static final String FRAG_EDIT = "FormEditFragment", FRAG_DISPLAY = "FormDisplayFragment";

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
    changeFragment(FragState.Display);
  }

  public void changeFragment(FragState fragState) {
    if (this.fragState != null && this.fragState == fragState) return;
    this.fragState = fragState;
    switch (fragState) {
      case Edit:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, FormEditFragment.getInstance(null), FRAG_EDIT)
            .commit();
        break;
      case Display:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, FormDisplayFragment.getInstance(null), FRAG_DISPLAY)
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
}
