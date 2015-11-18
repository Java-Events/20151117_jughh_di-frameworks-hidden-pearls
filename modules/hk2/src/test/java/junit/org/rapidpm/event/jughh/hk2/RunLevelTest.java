package junit.org.rapidpm.event.jughh.hk2;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.runlevel.RunLevelController;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by svenruppert on 01.11.15.
 */
public class RunLevelTest {


  @Inject RunLevelController runLevelController;

  private final ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

  @Before
  public void setUp() throws Exception {
    locator.inject(this);
  }


  /**
   * manchmal simpleName startMe= Level01
   simpleName startMe= Level02
   simpleName startMe= Level03_B
   simpleName startMe= Level03_A
   simpleName stopMe= Level03_A
   simpleName stopMe= Level03_B
   simpleName stopMe= Level02
   simpleName stopMe= Level01

   simpleName startMe= Level01
   simpleName startMe= Level02
   simpleName startMe= Level03_A
   simpleName startMe= Level03_B
   simpleName stopMe= Level03_B
   simpleName stopMe= Level03_A
   simpleName stopMe= Level02
   simpleName stopMe= Level01



   Reihenfolge beim Stop ist immer exact invers zum start
   * @throws Exception
   */
  @Test
  public void test001() throws Exception {
    runLevelController.proceedTo(1);
    runLevelController.proceedTo(2);
    runLevelController.proceedTo(3);


    runLevelController.proceedTo(-1);
  }

  /**
   * Runlevel werde nur einmal gestartet
   * @throws Exception
   */
  @Test
  public void test002() throws Exception {
    runLevelController.proceedTo(1);
    runLevelController.proceedTo(2);
    runLevelController.proceedTo(2);
    runLevelController.proceedTo(3);
    runLevelController.proceedTo(3);

    runLevelController.proceedTo(-1);
  }
}
