package org.rapidpm.event.jughh.weld.v001;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import java.util.List;

/**
 * Created by svenruppert on 10.11.15.
 */
public class WorkOnMyEvent {

  public void printHello(@Observes ContainerInitialized event, @Parameters List<String> parameters) {
    System.out.println("Hello " + parameters);
  }

  public void printHello(@Observes MyEvent myEvent) {
    System.out.println("MyEvent " + myEvent);
  }



}
