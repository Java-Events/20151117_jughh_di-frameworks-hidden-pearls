package org.rapidpm.event.jughh.dagger.step04.business;

import dagger.Module;
import dagger.Provides;
import org.rapidpm.event.jughh.dagger.Context;
import org.rapidpm.event.jughh.dagger.business.subservice.SubService;

import javax.inject.Named;
import javax.inject.Provider;

/**
 * Created by Sven Ruppert on 19.11.2014.
 */
@Module(library = true,
    includes = {SubService_A_Module.class, SubService_B_Module.class},
    complete = true)
public class SubServiceModule {
  @Provides
  SubService provideSubService(@Named("A") Provider<SubService> subServiceA,
                               @Named("B") Provider<SubService> subServiceB) {
    if (Context.getInstance().defaultImpl) { return subServiceA.get(); }
    else { return subServiceB.get(); }
  }
}
