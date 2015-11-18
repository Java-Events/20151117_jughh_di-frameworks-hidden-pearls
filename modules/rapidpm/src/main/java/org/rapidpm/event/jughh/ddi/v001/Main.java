package org.rapidpm.event.jughh.ddi.v001;

import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.Proxy;
import org.rapidpm.proxybuilder.type.dymamic.virtual.CreationStrategy;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 16.11.15.
 */
public class Main {


  public static void main(String[] args) {
    final Service service = ServiceAdapterBuilder.newBuilder()
        .setOriginal(null)
        .withDoWorkA(txt -> "mocked-" + txt)
        .buildForTarget(Service.class);

    System.out.println("service = " + service.doWorkA("XX"));

    final Service serviceAdapter = new ServiceStaticObjectAdapter()
        .withService(null)
        .withServiceMethodDoWorkA(txt -> "mocked-" + txt);

    System.out.println("service = " + serviceAdapter.doWorkA("XX"));
//

    DI.activatePackages(Main.class.getPackage().toString());

    final BusinessModule businessModule = DI.activateDI(new BusinessModule());
    System.out.println("businessModule.service.doWork(\"Text\") = " + businessModule.service.doWorkA("Text"));
//    final BusinessModuleProxy businessModuleProxy = DI.activateDI(new BusinessModuleProxy());
//    System.out.println("businessModule.service.doWork(\"Text\") = " + businessModuleProxy.service.doWork("Text"));


  }

  public static class BusinessModule {
    @Inject Service service;

    @PostConstruct
    public void post001(){
      System.out.println(" post001 = " + LocalDateTime.now() );
    }
    @PostConstruct
    public void post002(){
      System.out.println(" post002 = " + LocalDateTime.now() );
    }


  }

  public static class BusinessModuleProxy {
    @Inject @Proxy(
        virtual = true,
        proxyType = Proxy.ProxyType.DYNAMIC,
        concurrent = CreationStrategy.METHOD_SCOPED) Service service;
  }


}
