package com.gjc.service.impl;

import com.gjc.entity.AuthDO;
import com.gjc.dao.AuthDOMapper;
import com.gjc.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AuthServiceImpl extends ServiceImpl<AuthDOMapper, AuthDO> implements IAuthService {

    @Resource
    private AuthDOMapper authDOMapper;

    @Override
    public List<AuthDO> selectSysMenuByRoleId(Integer roleId) {
        return authDOMapper.selectSysMenuByRoleId(roleId);
    }

}
