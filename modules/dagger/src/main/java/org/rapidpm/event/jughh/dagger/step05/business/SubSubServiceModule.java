package org.rapidpm.event.jughh.dagger.step05.business;

import dagger.Module;
import dagger.Provides;
import org.rapidpm.event.jughh.dagger.business.subservice.subsubservice.SubSubService;
import org.rapidpm.event.jughh.dagger.business.subservice.subsubservice.SubSubServiceImpl;

import javax.inject.Singleton;

/**
 * Created by Sven Ruppert on 19.11.2014.
 */
@Module(library = true, complete = true)
public class SubSubServiceModule {
  @Provides @Singleton
  SubSubService provideSubSubService() {
    return new SubSubServiceImpl();
  }
}
