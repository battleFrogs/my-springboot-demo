package com.gjc.service.base.impl;

import com.gjc.entity.RoleAuthDO;
import com.gjc.dao.single.RoleAuthDOMapper;
import com.gjc.service.base.IRoleAuthService;
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
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthDOMapper, RoleAuthDO> implements IRoleAuthService {

}
