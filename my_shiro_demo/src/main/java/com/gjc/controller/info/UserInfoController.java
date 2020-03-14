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
     * @return resultData
     */
    @RequiresRoles("ADMIN")
    @RequestMapping("/getUserInfo")
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

}
