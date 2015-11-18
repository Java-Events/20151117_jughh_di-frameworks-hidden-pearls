package org.rapidpm.event.jughh.dagger2.v001;

import dagger.Component;
import org.rapidpm.event.jughh.dagger2.business.MainService;

/**
 * Created by svenruppert on 16.11.15.
 */

@Component(modules = BusinessModule.class)
public interface BusinessService {
  MainService makeMainService();
}
