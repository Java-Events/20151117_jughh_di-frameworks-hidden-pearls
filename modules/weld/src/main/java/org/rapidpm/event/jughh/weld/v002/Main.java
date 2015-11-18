package org.rapidpm.event.jughh.weld.v002;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 10.11.15.
 */
public class Main {
  public static void main(String[] args) {
    Weld weld = new Weld()
        .disableDiscovery()
        .packages(Main.class)
//        .interceptors(TransactionalInterceptor.class)
//        .addAlternative(..)
        .property("org.jboss.weld.construction.relaxed", true);
    try (WeldContainer container = weld.initialize()) {
      MyBean bean = container.select(MyBean.class).get();
      System.out.println(bean.computeResult());
    }
  }

  private static class MyBean {
    public String computeResult() {
      return LocalDateTime.now().toString();
    }
  }
}
