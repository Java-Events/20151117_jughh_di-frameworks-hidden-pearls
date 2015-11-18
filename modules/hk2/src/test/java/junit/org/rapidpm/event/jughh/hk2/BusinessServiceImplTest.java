package junit.org.rapidpm.event.jughh.hk2;

import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorState;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.event.jughh.hk2.BusinessService;
import org.rapidpm.event.jughh.hk2.BusinessServiceImplA;
import org.rapidpm.event.jughh.hk2.InjectionTarget;

import java.util.List;


/**
 * Created by svenruppert on 01.11.15.
 */
public class BusinessServiceImplTest {

  private final ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testDoWork() throws Exception {
    final BusinessService myService = locator.getService(BusinessService.class);

    Assert.assertNotNull(myService);

    Assert.assertEquals(myService.getClass(), BusinessServiceImplA.class);
    System.out.println("myService.doWork(\"h\") = " + myService.doWork("h"));
  }


  @Test
  public void test002() throws Exception {

    final ServiceLocatorState state = locator.getState();
    Assert.assertEquals(ServiceLocatorState.RUNNING,state);

    final BusinessService myService = locator.createAndInitialize(BusinessServiceImplA.class);

    Assert.assertNotNull(myService);
    Assert.assertEquals(myService.getClass(), BusinessServiceImplA.class);
    System.out.println("myService.doWork(\"h\") = " + myService.doWork("h"));

  }

  @Test
  public void test003() throws Exception {

    final List<BusinessService> allServices = locator.getAllServices(BusinessService.class);
    for (BusinessService myService : allServices) {
      Assert.assertNotNull(myService);
      System.out.println("myService.doWork(\"h\") = " + myService.doWork("h"));
    }

  }

  @Test
  public void test004() throws Exception {

    final ServiceHandle<BusinessService> serviceHandle = locator.getServiceHandle(BusinessService.class);
    final BusinessService myService = serviceHandle.getService();
    Assert.assertNotNull(myService);

    Assert.assertEquals(myService.getClass(), BusinessServiceImplA.class);
    System.out.println("myService.doWork(\"h\") = " + myService.doWork("h"));

    final Object serviceData = serviceHandle.getServiceData();
    System.out.println("serviceData = " + serviceData);


  }
  @Test
  public void test005() throws Exception {

    final InjectionTarget injectionTarget = locator.getService(InjectionTarget.class);
    Assert.assertNotNull(injectionTarget.service);
    Assert.assertNotNull(injectionTarget.serviceProxy);


  }
}