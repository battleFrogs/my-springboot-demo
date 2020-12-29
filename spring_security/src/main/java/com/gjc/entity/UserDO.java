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
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号状态
     */
    private String userStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", userStatus=" + userStatus +
                "}";
    }
}
