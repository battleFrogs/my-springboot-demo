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
@TableName("auth")
public class AuthDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限Id
     */
    @TableId(value = "auth_id", type = IdType.AUTO)
    private Integer authId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String permission;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AuthDO{" +
                "authId=" + authId +
                ", name=" + name +
                ", permission=" + permission +
                "}";
    }
}
