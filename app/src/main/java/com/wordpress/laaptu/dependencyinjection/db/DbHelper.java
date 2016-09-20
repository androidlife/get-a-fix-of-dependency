package com.wordpress.laaptu.dependencyinjection.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.key;

/**
 * Created by laaptu on 9/20/16.
 */

public class DbHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "userinfo";
  private static final int DB_VERSION = 1;
  public static final String USER_ID = "userId", NAME = "name", PHONE = "phone", ADDRESS =
      "address", EMAIL = "email";
  public static final String TABLE_USER = "userTable";

  public static final String CREATE_USER_TABLE = "create table if not exists "
      + TABLE_USER
      + "("
      + USER_ID
      + " integer primary key autoincrement, "
      + NAME
      + " text not null, "
      + PHONE
      + " text not null, "
      + ADDRESS
      + " text not null, "
      + EMAIL
      + " text not null);";

  public DbHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CREATE_USER_TABLE);
  }

  @Override public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    //database migration not handled
    sqLiteDatabase.execSQL("drop table if exists " + TABLE_USER);
    onCreate(sqLiteDatabase);
  }
}
