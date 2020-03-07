package com.gjc.service.base.impl;

import com.gjc.dao.single.UserDOMapper;
import com.gjc.entity.UserDO;
import com.gjc.service.base.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDOMapper, UserDO> implements IUserService {


}
