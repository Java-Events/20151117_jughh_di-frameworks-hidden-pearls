package org.rapidpm.event.jughh.dagger2.v001;

import dagger.Module;
import dagger.Provides;
import org.rapidpm.event.jughh.dagger2.Context;
import org.rapidpm.event.jughh.dagger2.business.MainService;
import org.rapidpm.event.jughh.dagger2.business.MainServiceImpl;
import org.rapidpm.event.jughh.dagger2.business.subservice.SubService;
import org.rapidpm.event.jughh.dagger2.business.subservice.impl_a.SubServiceA;
import org.rapidpm.event.jughh.dagger2.business.subservice.impl_b.SubServiceB;
import org.rapidpm.event.jughh.dagger2.business.subservice.subsubservice.SubSubService;
import org.rapidpm.event.jughh.dagger2.business.subservice.subsubservice.SubSubServiceImpl;

import javax.inject.Named;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 16.11.15.
 */
@Module
public class BusinessModule {
  @Provides MainService provideMainService(MainServiceImpl mainService) { return mainService; }

  @Provides @Named("A") SubService provideSubServiceA(SubServiceA subService) {
    return subService;
  }
  @Provides @Named("B") SubService provideSubServiceB(SubServiceB subService) {
    return subService;
  }

  @Provides SubSubService provideSubSubService() {
    return new SubSubServiceImpl();
  }

  @Provides
  SubService provideSubService(@Named("A") SubService subServiceA, @Named("B") SubService subServiceB) {
    System.out.println("provideSubService = " + LocalDateTime.now());
    if (Context.getInstance().defaultImpl) { return subServiceA; }
    else                                   { return subServiceB; }
  }
}

