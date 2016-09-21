package com.wordpress.laaptu.dependencyinjection.events;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 */

public class BusProvider {
  private static final Bus BUS = new Bus(ThreadEnforcer.MAIN);
  private static final BusProvider busProvider = new BusProvider();

  private BusProvider() {

  }

  public static BusProvider getEventBus() {
    return busProvider;
  }

  public void postEvent(Object event) {
    BUS.post(event);
  }

  public void register(Object object) {
    BUS.register(object);
  }

  public void unregister(Object object) {
    BUS.unregister(object);
  }
}
