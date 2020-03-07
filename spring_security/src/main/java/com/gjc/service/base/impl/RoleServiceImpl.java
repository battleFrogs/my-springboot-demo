package com.gjc.service.base.impl;

import com.gjc.entity.RoleDO;
import com.gjc.dao.single.RoleDOMapper;
import com.gjc.service.base.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDOMapper, RoleDO> implements IRoleService {

    @Resource
    private RoleDOMapper roleDOMapper;

    @Override
    public List<RoleDO> selectSysRoleByUserId(Integer userId) {
        return roleDOMapper.selectSysRoleByUserId(userId);
    }

}
