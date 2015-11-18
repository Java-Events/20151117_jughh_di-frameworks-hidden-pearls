package org.rapidpm.event.jughh.basics.v002;

import java.lang.reflect.Field;

/**
 * Created by svenruppert on 10.11.15.
 */
public class Main {


  public static void main(String[] args) {

    final BusinessModulA businessModulA = new BusinessModulA(new Service2Inject());
    businessModulA.work();


    final BusinessModulB businessModulB = new BusinessModulB();
    businessModulB.setService(new Service2Inject());
    businessModulB.work();

    final BusinessModulC businessModulC = new BusinessModulC();
    try {
      final Field serviceField = BusinessModulC.class.getDeclaredField("service");
      serviceField.set(businessModulC, new Service2Inject());
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
    businessModulC.work();

  }


  public static class Service2Inject implements Service {
    public String doWork() {
      return null;
    }
  }

  public interface Service {
    String doWork();
  }


  //constructor
  public static class BusinessModulA {
    private Service service;

    public BusinessModulA(final Service service) {
      this.service = service;
    }
    public void work() {
      service.doWork();
    }
  }

  //setter
  public static class BusinessModulB {
    private Service service;

    public BusinessModulB() {
    }

    public void setService(final Service service) {
      this.service = service;
    }

    public void work() {
      service.doWork();
    }
  }

  //reflection
  public static class BusinessModulC {
    private Service service;

    public BusinessModulC() {
    }

    public void work() {
      service.doWork();
    }

  }


}
