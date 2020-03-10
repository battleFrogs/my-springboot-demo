package com.gjc.service;

import com.gjc.entity.RoleDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjc
 * @since 2020-03-08
 */
public interface IRoleService extends IService<RoleDO> {

    List<RoleDO> selectSysRoleByUserId(Integer userId);
}
