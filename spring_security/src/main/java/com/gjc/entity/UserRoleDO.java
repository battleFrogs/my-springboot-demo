package com.gjc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@TableName("user_role")
public class UserRoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色用户关系Id
     */
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 角色Id
     */
    private Integer roleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleDO{" +
            "userRoleId=" + userRoleId +
            ", userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
