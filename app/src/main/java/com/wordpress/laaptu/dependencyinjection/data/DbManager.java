package com.wordpress.laaptu.dependencyinjection.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.wordpress.laaptu.dependencyinjection.model.User;

/**
 */

public class DbManager implements DataService {

  private SQLiteDatabase db;

  public DbManager(Context context) {
    init(context);
  }

  private void init(Context context) {
    DbHelper dbHelper = new DbHelper(context);
    if (db == null) {
      db = dbHelper.getWritableDatabase();
    }
  }

  public void closeDatabase() {
    if (db != null) {
      db.close();
    }
    db = null;
  }

  public void storeUser(User user) {
    Cursor cursor = getStoredUser();
    boolean isUpdate = cursor.getCount() > 0;
    cursor.close();
    ContentValues cv = new ContentValues();
    cv.put(DbHelper.USER_ID, user.getUserId());
    cv.put(DbHelper.ADDRESS, user.address);
    cv.put(DbHelper.EMAIL, user.email);
    cv.put(DbHelper.PHONE, user.phone);
    cv.put(DbHelper.NAME, user.name);
    if (isUpdate) {
      db.update(DbHelper.TABLE_USER, cv, DbHelper.USER_ID + "=?",
          new String[] { String.valueOf(user.getUserId()) });
    } else {
      db.insert(DbHelper.TABLE_USER, null, cv);
    }
  }

  private Cursor getStoredUser() {
    return db.rawQuery("select * from "
        + DbHelper.TABLE_USER
        + " where "
        + DbHelper.USER_ID
        + " = "
        + User.getUniqueUserId(), null);
  }

  public User getUser() {
    Cursor cursor = getStoredUser();
    User user = null;
    if (cursor.getCount() > 0) {
      user = new User();
      cursor.moveToNext();
      user.name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
      user.email = cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL));
      user.address = cursor.getString(cursor.getColumnIndex(DbHelper.ADDRESS));
      user.phone = cursor.getString(cursor.getColumnIndex(DbHelper.PHONE));
    }
    cursor.close();
    return user;
  }
}
