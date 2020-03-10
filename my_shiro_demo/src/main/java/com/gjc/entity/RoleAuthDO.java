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
 * @since 2020-03-08
 */
@TableName("role_auth")
public class RoleAuthDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限关系表
     */
    @TableId(value = "role_auth_id", type = IdType.AUTO)
    private Integer roleAuthId;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 权限ID
     */
    private Integer authId;

    public Integer getRoleAuthId() {
        return roleAuthId;
    }

    public void setRoleAuthId(Integer roleAuthId) {
        this.roleAuthId = roleAuthId;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "RoleAuthDO{" +
            "roleAuthId=" + roleAuthId +
            ", roleId=" + roleId +
            ", authId=" + authId +
        "}";
    }
}
