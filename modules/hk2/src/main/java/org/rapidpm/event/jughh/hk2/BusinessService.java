package org.rapidpm.event.jughh.hk2;

import org.jvnet.hk2.annotations.Contract;

/**
 * Created by svenruppert on 01.11.15.
 */
@Contract
public interface BusinessService {
  String doWork(String txt);
}
