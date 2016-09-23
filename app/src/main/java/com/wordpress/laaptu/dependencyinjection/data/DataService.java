package com.wordpress.laaptu.dependencyinjection.data;

import com.wordpress.laaptu.dependencyinjection.model.User;

/**
 */

public interface DataService {
  User getUser();

  void storeUser(User user);
}
