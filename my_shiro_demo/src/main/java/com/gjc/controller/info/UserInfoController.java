package com.gjc.controller.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.dao.UserRoleDOMapper;
import com.gjc.dao.UserRoleRelationMapper;
import com.gjc.entity.DTO.UserRoleRelationDTO;
import com.gjc.entity.UserDO;
import com.gjc.entity.UserRoleDO;
import com.gjc.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserRoleRelationMapper userRoleRelationMapper;
    @Resource
    private UserRoleDOMapper userRoleDOMapper;

    /**
     * 获取用户信息
     *
     * @return resultData
     */
    @RequiresRoles("DEVELOPER")
    @RequestMapping("/getUserInfo")
    // //必须同时属于user和admin角色
    //@RequiresRoles({"user","admin"})
    //
    ////属于user或者admin之一;修改logical为OR 即可
    //@RequiresRoles(value={"user","admin"},logical=Logical.OR)
    public ResultData getUserInfo() {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        UserDO userDO = ShiroUtils.getUserInfo();
        Integer userId = userDO.getUserId();
        UserRoleRelationDTO userRoleRelationDTO = userRoleRelationMapper.getUserInfo(userId);
        resultData.setCode(RetCode.SUCCESS.getCode());
        resultData.addData("userRoleRelationDTO", userRoleRelationDTO);
        resultData.setMsg("获取用户信息成功");
        return resultData;
    }

    /**
     * 获取用户信息
     *
     * @return resultData
     */
    @RequiresRoles("TEST")
    @RequestMapping("/getRoleInfo")
    public ResultData getRoleInfo() {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        UserDO userDO = (UserDO) principals.getPrimaryPrincipal();
        Integer userId = userDO.getUserId();
        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>();
        List<UserRoleDO> userRoleDOList = userRoleDOMapper.selectList(queryWrapper.lambda().eq(UserRoleDO::getUserId, userId));
        resultData.addData("userRoleDOS", userRoleDOList);
        resultData.setCode(RetCode.SUCCESS.getCode());
        resultData.setMsg("获取用户信息成功");
        return resultData;
    }


    @RequestMapping("/getRoleInfo2")
    @RequiresPermissions("sys:role:info")
    // //必须同时复核index:hello和index:world权限要求
    //@RequiresPermissions({"index:hello","index:world"})
    //
    ////符合index:hello或index:world权限要求即可
    //@RequiresPermissions(value={"index:hello","index:world"},logical=Logical.OR)
    public ResultData getRoleInfo2() {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        UserDO userDO = (UserDO) principals.getPrimaryPrincipal();
        Integer userId = userDO.getUserId();
        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>();
        List<UserRoleDO> userRoleDOList = userRoleDOMapper.selectList(queryWrapper.lambda().eq(UserRoleDO::getUserId, userId));
        resultData.addData("userRoleDOS", userRoleDOList);
        resultData.setCode(RetCode.SUCCESS.getCode());
        resultData.setMsg("获取用户信息成功");
        return resultData;
    }
}
