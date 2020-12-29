package com.gjc.service.base.impl;

import com.gjc.entity.UserRoleDO;
import com.gjc.dao.single.UserRoleDOMapper;
import com.gjc.service.base.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDOMapper, UserRoleDO> implements IUserRoleService {

}
