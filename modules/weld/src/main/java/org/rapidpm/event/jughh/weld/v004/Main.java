package org.rapidpm.event.jughh.weld.v004;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.rapidpm.event.jughh.weld.v004.model.DEV;
import org.rapidpm.event.jughh.weld.v004.model.Prod;
import org.rapidpm.event.jughh.weld.v004.model.Service;
import org.rapidpm.event.jughh.weld.v004.model.WithProducer;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

/**
 * Created by svenruppert on 10.11.15.
 */
public class Main {

  @Inject Service serviceDefault;
  @Inject @Prod Service serviceProd;
  @Inject @DEV Service serviceDev;
  @Inject @WithProducer Service serviceWithProducer;

  @Inject Instance<Service> serviceDefaultProxy;
  @Inject @Prod Instance<Service> serviceProdProxy;
  @Inject @DEV Instance<Service> serviceDevProxy;
  @Inject @WithProducer Instance<Service> serviceWithProducerProxy;

  public static void main(String[] args) {
    Weld weld = new Weld()
        .disableDiscovery()
        .addPackages(true,Main.class);

    try (WeldContainer container = weld.initialize()) {
      Service serviceDefault = container.select(Service.class).get();
      System.out.println(serviceDefault.doWork("Hello"));
      Service serviceProd = container.select(Service.class).select(new AnnotationLiteral<Prod>(){}).get();
      System.out.println(serviceProd.doWork("Hello"));
      Service serviceDev = container.select(Service.class).select(new AnnotationLiteral<DEV>(){}).get();
      System.out.println(serviceDev.doWork("Hello"));

      Service serviceDevProxy = container
          .instance()
          .select(Service.class)
          .select(new AnnotationLiteral<DEV>(){})
          .get();
      System.out.println(serviceDevProxy.doWork("Hello"));

      final Main main = container.select(Main.class).get();
      System.out.println(main.serviceDefault.doWork("Hello"));
      System.out.println(main.serviceProd.doWork("Hello"));
      System.out.println(main.serviceDev.doWork("Hello"));
      System.out.println(main.serviceWithProducer.doWork("Hello"));

      System.out.println(main.serviceDefaultProxy.get().doWork("Hello"));
      System.out.println(main.serviceProdProxy.get().doWork("Hello"));
      System.out.println(main.serviceDevProxy.get().doWork("Hello"));
      System.out.println(main.serviceWithProducerProxy.get().doWork("Hello"));

    }
  }


  public <T> T activateCDI(T t) {
    final Class aClass = t.getClass();
    final BeanManager beanManager = CDI.current().getBeanManager();
    final AnnotatedType annotationType
        = beanManager.createAnnotatedType(aClass);
    final InjectionTarget injectionTarget
        = beanManager.createInjectionTarget(annotationType);
    final CreationalContext creationalContext
        = beanManager.createCreationalContext(null);
    injectionTarget.inject(t, creationalContext);
    injectionTarget.postConstruct(t);
    return t;
  }


  public static class ServiceProducer{
    @Produces @WithProducer
    public Service create(){
      return txt -> Service.class.getSimpleName() + " " + txt;
    }
  }


}
