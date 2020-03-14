package com.gjc.controller.login;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.entity.UserDO;
import com.gjc.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 登录接口
     * @param userDO
     * @return
     */
    @RequestMapping("/userLogin")
    public ResultData userLogin(UserDO userDO) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userDO.getUsername(), userDO.getPassword());
        subject.login(token); // 走身份认证接口
        resultData.setMsg("登录成功");
        resultData.setCode(RetCode.SUCCESS.getCode());
        return resultData;
    }

    /**
     * 未登录接口
     */
    @RequestMapping("/noLogin")
    public ResultData noLogin() {
        return new ResultData(RetCode.FAIL.getCode(), "未登录");
    }


    /**
     * 登出(测试登出)
     */
    @RequestMapping("/getLogout")
    @RequiresUser
    public ResultData getLogout(){
        ShiroUtils.logout();
        return new ResultData(RetCode.SUCCESS.getCode(), "登出成功");
    }


}
