package org.rapidpm.event.jughh.ddi.v001;

import org.rapidpm.proxybuilder.objectadapter.annotations.dynamicobjectadapter.DynamicObjectAdapterBuilder;
import org.rapidpm.proxybuilder.objectadapter.annotations.staticobjectadapter.StaticObjectAdapter;

/**
 * Created by svenruppert on 16.11.15.
 */
@DynamicObjectAdapterBuilder
@StaticObjectAdapter
public interface Service {
  String doWorkA(String txt);
  String doWorkB(String txt);
}
