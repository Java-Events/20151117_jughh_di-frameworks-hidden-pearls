package org.rapidpm.event.jughh.weld.v004.model;

/**
 * Created by svenruppert on 10.11.15.
 */
@Prod
public class Service_A implements Service {
  @Override
  public String doWork(String txt) {
    return this.getClass().getSimpleName() + " " + txt;
  }
}
