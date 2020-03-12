package com.gjc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjc.entity.DTO.UserRoleRelationDTO;
import com.gjc.entity.UserRoleDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjc
 * @since 2020-03-08
 */
public interface UserRoleRelationMapper {

    UserRoleRelationDTO getUserInfo(Integer userId);

}
