package org.rapidpm.event.jughh.dagger.step04.business;

import dagger.Module;
import dagger.Provides;
import org.rapidpm.event.jughh.dagger.business.subservice.subsubservice.SubSubService;
import org.rapidpm.event.jughh.dagger.business.subservice.subsubservice.SubSubServiceImpl;

/**
 * Created by Sven Ruppert on 19.11.2014.
 */
@Module(library = true, complete = true)
public class SubSubServiceModule {
  @Provides
  SubSubService provideSubSubService() {
    return new SubSubServiceImpl();
  }
}
