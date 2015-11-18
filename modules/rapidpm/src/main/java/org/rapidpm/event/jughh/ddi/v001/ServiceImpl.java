package org.rapidpm.event.jughh.ddi.v001;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 16.11.15.
 */
public class ServiceImpl implements Service {
  @Override
  public String doWork(final String txt) {
    return this.getClass().getSimpleName() + " " + txt;
  }

  public ServiceImpl() {
    System.out.println("ServiceImpl.constructor() = " + LocalDateTime.now());
  }

  @PostConstruct
  public void post001(){
    System.out.println(" ServiceImpl.post001 = " + LocalDateTime.now() );
  }
  @PostConstruct
  public void post002(){
    System.out.println(" ServiceImpl.post002 = " + LocalDateTime.now() );
  }


}
