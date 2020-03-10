package com.gjc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.dao.RoleDOMapper;
import com.gjc.entity.RoleDO;
import com.gjc.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDOMapper, RoleDO> implements IRoleService {


    @Resource
    private RoleDOMapper roleDOMapper;

    @Override
    public List<RoleDO> selectSysRoleByUserId(Integer userId) {
        QueryWrapper<RoleDO> roleQueryWrapper = new QueryWrapper<>();
        List<RoleDO> roleList = roleDOMapper.selectSysRoleByUserId(userId);
        return roleList;
    }
}
