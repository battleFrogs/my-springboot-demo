package com.gjc.service.impl;

import com.gjc.entity.UserDO;
import com.gjc.dao.UserDOMapper;
import com.gjc.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDOMapper, UserDO> implements IUserService {

}
