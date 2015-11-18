package org.rapidpm.event.jughh.dagger.step05.business;

import dagger.Module;
import dagger.Provides;
import org.rapidpm.event.jughh.dagger.business.subservice.SubService;
import org.rapidpm.event.jughh.dagger.business.subservice.impl_b.SubServiceB;

import javax.inject.Named;

/**
 * Created by Sven Ruppert on 19.11.2014.
 */

@Module(library = true,
    includes = SubSubServiceModule.class,
    complete = true)
public class SubService_B_Module {

  @Provides
  @Named("B")
  SubService provideSubServiceB(SubServiceB subService) {
    return subService;
  }

}
