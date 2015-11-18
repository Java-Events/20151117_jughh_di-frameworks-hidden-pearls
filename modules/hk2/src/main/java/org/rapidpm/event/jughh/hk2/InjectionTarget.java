package org.rapidpm.event.jughh.hk2;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Provider;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 01.11.15.
 */
@Service
public class InjectionTarget implements Target{

  @Inject public BusinessService service;
  @Inject public Provider<BusinessService> serviceProvider;
  @Inject public BusinessServiceImplB serviceProxy;

//  @Inject @UseProxy
//  public void setServiceProxy(final BusinessService serviceProxy) {
//    this.serviceProxy = serviceProxy;
//  }
}
