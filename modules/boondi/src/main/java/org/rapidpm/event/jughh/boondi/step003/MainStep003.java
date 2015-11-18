package org.rapidpm.event.jughh.boondi.step003;


import org.boon.di.Context;
import org.boon.di.DependencyInjection;
import org.boon.di.Module;

/**
 * Created by Sven Ruppert on 01.12.2014.
 */
public class MainStep003 {

  public static void main(String[] args) {
    //NPE
//        final Module module = DependencyInjection.classes(Service.class);
//    final Service service1 = module.get(Service.class);
//    service1.printInfo();

//    final Module moduleA = DependencyInjection.module(new ServiceModuleA());
//    final Module moduleB = DependencyInjection.module(new ServiceModuleB());
//    final Context context = DependencyInjection.context(moduleA);
//    final Context context = DependencyInjection.context(moduleA,moduleB);
//    final Context add = context.add(moduleB);
//    final Context context = DependencyInjection.context(moduleB, moduleA);
//        final Context context = DependencyInjection.context(moduleB);
//    final Context add = context.add(moduleA);
//    System.out.println("service? = " + context.has(Service.class));
//    context.get(Service.class);
//    add.get(Service.class);
//    context.remove(moduleB);
//    context.get(Service.class);
    multipleTests();
  }

  private static void multipleTests() {
    final Module moduleA1 = DependencyInjection.module(new ServiceModuleA());
    final Module moduleA2 = DependencyInjection.module(new ServiceModuleA());
    final Module moduleB1 = DependencyInjection.module(new ServiceModuleB());
    final Module moduleB2 = DependencyInjection.module(new ServiceModuleB());

    final Context context = DependencyInjection
        .context(moduleA1).add(moduleB1).add(moduleA2).add(moduleB2);
    context.get(Service.class);
    context.remove(moduleA1);
    context.get(Service.class);
    context.remove(moduleB1);
    context.get(Service.class);
    context.remove(moduleA2);
    context.get(Service.class);
    context.remove(moduleB2);
  }


  public static class ServiceModuleA {
    public Service provideServiceA() {
      System.out.println("provideServiceAA ...");
      return new ServiceImpl();
    }
    public Service provideServiceB() {
      System.out.println("provideServiceAB ...");
      return new ServiceImpl();
    }
    public Service provideServiceC() {
      System.out.println("provideServiceAC ...");
      return new ServiceImpl();
    }
  }

  public static class ServiceModuleB {
    public Service provideServiceA() {
      System.out.println("provideServiceBA ...");
      return new ServiceImpl();
    }
    public Service provideServiceB() {
      System.out.println("provideServiceBB ...");
      return new ServiceImpl();
    }
    public Service provideServiceC() {
      System.out.println("provideServiceBC ...");
      return new ServiceImpl();
    }
  }


}
