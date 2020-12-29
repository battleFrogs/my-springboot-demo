package com.gjc.controller.register;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.entity.UserDO;
import com.gjc.service.base.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private IUserService userService;

    /**
     * 用户注册
     *
     * @param username 账号
     * @param password 密码
     * @return resultData
     */
    @RequestMapping("/userRegister")
    public ResultData userRegister(String username, String password) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        if (StringUtils.isBlank(username)) {
            resultData.setMsg("用户账号为空");
            return resultData;
        }

        if (StringUtils.isBlank(username)) {
            resultData.setMsg("用户账号为空");
            return resultData;
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userDO.setUserStatus("NORMAL");
        userService.save(userDO);

        resultData.setMsg("注册成功");
        resultData.setCode(RetCode.SUCCESS.getCode());
        return resultData;
    }

}
