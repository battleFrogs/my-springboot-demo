package com.gjc.controller;


import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.entity.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gjc
 * @since 2020-03-08
 */
@RestController
@RequestMapping("/role")
public class RoleController {


    @RequestMapping("roleInfo")
    public ResultData getRoleInfo() {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();
        resultData.setCode(RetCode.SUCCESS.getCode());
        resultData.setMsg("登录成功");
        resultData.addData("userDo",user);
        return resultData;
    }

}

