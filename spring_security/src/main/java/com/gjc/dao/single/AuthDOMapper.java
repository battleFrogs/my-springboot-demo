package com.gjc.dao.single;

import com.gjc.entity.AuthDO;
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
public interface AuthDOMapper extends BaseMapper<AuthDO> {

    List<AuthDO> selectSysMenuByUserId(Integer userId);
}
