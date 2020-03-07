package com.gjc.service.base.impl;

import com.gjc.entity.AuthDO;
import com.gjc.dao.single.AuthDOMapper;
import com.gjc.service.base.IAuthService;
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
public class AuthServiceImpl extends ServiceImpl<AuthDOMapper, AuthDO> implements IAuthService {

    @Resource
    private AuthDOMapper authDOMapper;

    @Override
    public List<AuthDO> selectSysMenuByUserId(Integer userId) {
        return authDOMapper.selectSysMenuByUserId(userId);
    }

}
