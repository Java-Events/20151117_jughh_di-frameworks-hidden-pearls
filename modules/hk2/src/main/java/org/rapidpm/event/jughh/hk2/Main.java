package org.rapidpm.event.jughh.hk2;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

/**
 * Created by svenruppert on 01.11.15.
 */
public class Main {

  private Main() {
  }

  public static void main(String[] args) {
    ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

    final BusinessService myService = locator.getService(BusinessService.class);

    final InjectionTarget injectionTarget = locator.getService(InjectionTarget.class);
    final BusinessService businessService = injectionTarget.serviceProvider.get();


  }
}
