package com.gjc.entity.DTO;

import com.gjc.entity.RoleDO;

import java.util.List;

public class UserRoleRelationDTO {

    private Integer userId;

    private String username;

    private String userStatus;

    private List<RoleDO> roleDOList;

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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public List<RoleDO> getRoleDOList() {
        return roleDOList;
    }

    public void setRoleDOList(List<RoleDO> roleDOList) {
        this.roleDOList = roleDOList;
    }
}
