package org.rapidpm.event.jughh.boondi.step003.info;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sven Ruppert on 02.12.2014.
 */
public class ReflectionDemo {
  public static void main(String[] args) {
    final Method[] declaredMethods = DemoKlasse.class.getDeclaredMethods();
    for (final Method declaredMethod : declaredMethods) {
      System.out.println("declaredMethod = " + declaredMethod.getName());
    }


    final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    concurrentHashMap.put("provideServiceA", "provideServiceA");
    concurrentHashMap.put("provideServiceC", "provideServiceC");
    concurrentHashMap.put("provideServiceD", "provideServiceD");
    concurrentHashMap.put("provideServiceB", "provideServiceB");

    for (Object o : concurrentHashMap.keySet()) {
      System.out.println("o = " + o + " hash - " + o.hashCode());
    }

    concurrentHashMap.keySet().forEach(System.out::println);
    concurrentHashMap.entrySet().forEach(System.out::println);
    concurrentHashMap.values().forEach(System.out::println);


    concurrentHashMap.clear();
    concurrentHashMap.put("provideServiceXA", "provideServiceXA");
    concurrentHashMap.put("provideServiceXB", "provideServiceXB");
    concurrentHashMap.put("provideServiceXC", "provideServiceXC");
    concurrentHashMap.put("provideServiceXD", "provideServiceXD");

    for (Object o : concurrentHashMap.keySet()) {
      System.out.println("o = " + o);
    }

  }

  private static class DemoKlasse {
    public void methodB() {
    }

    public void methodC() {
    }

    public void methodA() {
    }
  }
}
