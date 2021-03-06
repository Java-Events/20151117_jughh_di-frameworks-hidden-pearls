/*
 * Copyright [2014] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rapidpm.event.jughh.dagger.business;


import org.rapidpm.event.jughh.dagger.business.subservice.SubService;

import javax.inject.Inject;

/**
 * Created by Sven Ruppert on 17.11.2014.
 */
public class MainServiceImpl implements MainService {

//  @Inject Provider<SubService> subService;
  @Inject SubService subService;

  public String execute(String txt){
//    return subService.get().work(txt);
    return subService.work(txt);
  }
}
