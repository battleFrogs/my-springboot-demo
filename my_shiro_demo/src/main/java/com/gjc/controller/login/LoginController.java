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
    public ResultData userLogin(@RequestBody UserDO userDO) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userDO.getUsername(), userDO.getPassword());
            subject.login(token); // 走身份认证接口
        } catch (IncorrectCredentialsException e) {
            resultData.setMsg("用户不存在或者密码错误");
            return resultData;
        } catch (LockedAccountException e) {
            resultData.setMsg("登录失败，该用户已被冻结");
            return resultData;
        } catch (AuthenticationException e) {
            resultData.setMsg("该用户不存在");
            return resultData;
        } catch (Exception e) {
            resultData.setMsg("用户不存在或者密码错误");
            return resultData;
        }
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

}
