package org.rapidpm.event.jughh.weld.v004.model;

/**
 * Created by svenruppert on 10.11.15.
 */
public class ServiceDefault implements Service{
  @Override
  public String doWork(final String txt) {
    return this.getClass().getSimpleName() + " " + txt;
  }
}
