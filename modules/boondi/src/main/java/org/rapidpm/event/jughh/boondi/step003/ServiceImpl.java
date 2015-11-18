package org.rapidpm.event.jughh.boondi.step003;

import org.rapidpm.event.jughh.boondi.PrintInfo;

/**
 * Created by Sven Ruppert on 01.12.2014.
 */
public class ServiceImpl implements Service {
  public void printInfo() {
    PrintInfo.printInfo(this.getClass());
  }
}
