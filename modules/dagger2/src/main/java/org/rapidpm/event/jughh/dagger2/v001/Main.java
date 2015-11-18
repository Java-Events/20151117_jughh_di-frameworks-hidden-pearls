package org.rapidpm.event.jughh.dagger2.v001;

import org.rapidpm.event.jughh.dagger2.Context;
import org.rapidpm.event.jughh.dagger2.business.MainService;


/**
 * Created by svenruppert on 16.11.15.
 */
public class Main {


  public static void main(String[] args) {
    //bootstrapping
//    Main main = new Main();
//    final ObjectGraph objectGraph = ObjectGraph.create(new BusinessModule());
//    final Main main = objectGraph.get(Main.class);

    final BusinessService businessService = DaggerBusinessService.builder()
        .businessModule(new BusinessModule())
        .build();

    final MainService mainService = businessService.makeMainService();

//    objectGraph.inject(main);
    System.out.println("execute = " + mainService.execute("Und Los"));
    Context.getInstance().defaultImpl = false;
    System.out.println("execute = " + mainService.execute("Und Los"));
    Context.getInstance().defaultImpl = true;
    System.out.println("execute = " + mainService.execute("Und Los"));
  }
}
