package org.rapidpm.event.jughh.dagger.step00.step00b.business.subservice;

import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 19.11.2014.
 */
public abstract class BaseSubService implements SubService {

  public BaseSubService() {
    System.out.println(this.getClass().getSimpleName() + " = " + LocalDateTime.now());
  }
}
