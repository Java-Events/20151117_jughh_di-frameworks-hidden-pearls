package org.rapidpm.event.jughh.hk2;

import org.glassfish.hk2.api.UseProxy;
import org.jvnet.hk2.annotations.Service;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 01.11.15.
 */
@Service @UseProxy
public class BusinessServiceImplB implements BusinessService {


  public BusinessServiceImplB() {
    System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
  }

  @Override
  public String doWork(final String txt) {
    return this.getClass().getSimpleName() + "-" + txt;
  }
}
