package com.gjc.dao.single;

import com.gjc.entity.RoleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
public interface RoleDOMapper extends BaseMapper<RoleDO> {

    List<RoleDO> selectSysRoleByUserId(Integer userId);

}
