package com.gjc.service.base;

import com.gjc.entity.AuthDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
public interface IAuthService extends IService<AuthDO> {

    List<AuthDO> selectSysMenuByUserId(Integer userId);

}
