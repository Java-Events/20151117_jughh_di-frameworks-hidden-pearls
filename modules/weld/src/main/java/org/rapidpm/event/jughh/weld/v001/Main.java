package org.rapidpm.event.jughh.weld.v001;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by svenruppert on 10.11.15.
 */
public class Main {
  public static void main(String[] args) {
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();
    final MyEvent myEvent = new MyEvent();
    myEvent.setMessage("Event will be fired");
    container.event().select(MyEvent.class).fire(myEvent);
    // When all observer methods are notified the container shuts down
    container.shutdown();
  }
}
