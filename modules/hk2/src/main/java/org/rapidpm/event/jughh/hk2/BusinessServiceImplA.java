package org.rapidpm.event.jughh.hk2;

import org.jvnet.hk2.annotations.Service;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 01.11.15.
 */
@Service
public class BusinessServiceImplA implements BusinessService {
  @Override
  public String doWork(final String txt) {
    return this.getClass().getSimpleName() + "-" + txt;
  }

  public BusinessServiceImplA() {
    System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
  }
}
