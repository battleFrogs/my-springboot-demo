package com.gjc.service.business;

import com.gjc.config.entity.SelfUserEntity;

public interface SelfUserDetailsService {


    SelfUserEntity loadUserByUsername(String userName);


}
