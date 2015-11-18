package org.rapidpm.event.jughh.weld.v003;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 10.11.15.
 */
public class Main {

  public static void main(String[] args) {
    Weld weld = new Weld()
        .disableDiscovery();
    weld.containerId("one").beanClasses(MyBean.class).initialize();
    weld.containerId("two").beanClasses(OtherBean.class).initialize();

    MyBean bean = WeldContainer.instance("one").select(MyBean.class).get();
    System.out.println(bean.computeResult());

// Shutdown the first container
    WeldContainer.instance("one").shutdown();
// Shutdown all the containers initialized by the builder instance
    weld.shutdown();
  }

  private static class MyBean {
    public String computeResult() {
      return LocalDateTime.now().toString();
    }
  }

  private static class OtherBean {
  }
}
