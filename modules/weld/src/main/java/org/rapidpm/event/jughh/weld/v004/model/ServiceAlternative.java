package org.rapidpm.event.jughh.weld.v004.model;

import javax.enterprise.inject.Alternative;

/**
 * Created by svenruppert on 10.11.15.
 */
@Alternative
public class ServiceAlternative implements Service {
  @Override
  public String doWork(String txt) {
    return this.getClass().getSimpleName() + " " + txt;
  }
}
