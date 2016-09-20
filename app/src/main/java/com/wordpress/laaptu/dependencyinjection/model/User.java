package com.wordpress.laaptu.dependencyinjection.model;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Parcel;
import android.os.Parcelable;

/**
 */

public class User implements Parcelable {

  private static final int USER_ID = 9;
  private int userId = USER_ID;
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

  /**
   * Just one user to be stored
   */
  public static int getUniqueUserId() {
    return USER_ID;
  }

  @Override public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getUserId());
    stringBuilder.append(name);
    stringBuilder.append(email);
    stringBuilder.append(phone);
    stringBuilder.append(address);
    return stringBuilder.toString();
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
