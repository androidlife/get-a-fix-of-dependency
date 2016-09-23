package com.wordpress.laaptu.dependencyinjection.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.model.User;
import org.json.JSONException;
import org.json.JSONObject;

/**
 */

public class PrefManager implements DataService {

  private SharedPreferences sharedPreferences;

  public static final String PREF_NAME = "diPref";
  private Context context;

  public PrefManager(Context context, String prefName) {
    sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    this.context = context;
  }

  public User getUser() {
    User user = null;
    String jsonString = sharedPreferences.getString(String.valueOf(User.getUniqueUserId()), null);
    if (jsonString != null) {
      try {
        JSONObject jsonObject = new JSONObject(jsonString);
        user = new User();
        user.name = jsonObject.getString(getString(R.string.name));
        user.address = jsonObject.getString(getString(R.string.address));
        user.phone = jsonObject.getString(getString(R.string.phone));
        user.email = jsonObject.getString(getString(R.string.email));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return user;
  }

  public void storeUser(User user) {
    if (user == null) return;
    JSONObject jsonObject = new JSONObject();
    try {
      String userId = String.valueOf(user.getUserId());
      putJsonValues(jsonObject, R.string.id, userId);
      putJsonValues(jsonObject, R.string.name, user.name);
      putJsonValues(jsonObject, R.string.address, user.address);
      putJsonValues(jsonObject, R.string.phone, user.phone);
      putJsonValues(jsonObject, R.string.email, user.email);
      SharedPreferences.Editor editor = sharedPreferences.edit();
      System.out.println(jsonObject.toString());
      editor.putString(userId, jsonObject.toString());
      editor.apply();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public void removeAll() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.clear();
    editor.apply();
  }

  private String getString(int stringId) {
    return context.getString(stringId);
  }

  private void putJsonValues(JSONObject jsonObject, int nameId, String value) throws JSONException {
    jsonObject.put(getString(nameId), value);
  }
}
