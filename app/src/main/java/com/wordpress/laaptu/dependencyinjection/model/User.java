package com.wordpress.laaptu.dependencyinjection.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 */

public class User implements Parcelable {

  private int userId = 9;
  public String name, email, address, phone;

  public int getUserId() {
    return userId;
  }

  public User() {

  }

  public static User getUser() {
    User user = new User();
    user.name = "Santosh Dhakal";
    user.email = "sanimap@gmail.com";
    user.address = "Koteshwor, Kathmandu";
    user.phone = "9801079923";
    return user;
  }

  protected User(Parcel in) {
    userId = in.readInt();
    name = in.readString();
    email = in.readString();
    address = in.readString();
    phone = in.readString();
  }

  public static final Creator<User> CREATOR = new Creator<User>() {
    @Override public User createFromParcel(Parcel in) {
      return new User(in);
    }

    @Override public User[] newArray(int size) {
      return new User[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(userId);
    parcel.writeString(name);
    parcel.writeString(email);
    parcel.writeString(address);
    parcel.writeString(phone);
  }
}
