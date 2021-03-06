package com.gjc.service.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gjc.config.entity.SelfUserEntity;
import com.gjc.dao.single.UserDOMapper;
import com.gjc.entity.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelfUserDetailsService implements UserDetailsService {

    @Resource
    private UserDOMapper userDOMapper;

    @Override
    public SelfUserEntity loadUserByUsername(String userName) {
        QueryWrapper<UserDO> userDOQueryWrapper = new QueryWrapper<>();
        UserDO userDO = userDOMapper.selectOne(userDOQueryWrapper.lambda().eq(UserDO::getUsername, userName));
        if (userDO == null) {
            return null;
        }
        SelfUserEntity selfUserEntity = new SelfUserEntity();
        BeanUtils.copyProperties(userDO, selfUserEntity);
        return selfUserEntity;
    }
}
