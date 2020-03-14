package com.gjc.controller.register;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.entity.UserDO;
import com.gjc.service.IUserService;
import com.gjc.utils.EncryptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private IUserService userService;

    @RequestMapping("/userRegister")
    public ResultData userRegister(String username,String password) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        Map<String, String> encryption = EncryptionUtil.encryption(password);
        UserDO userDO = new UserDO();
        String salt = encryption.get("salt");
        String newPassword = encryption.get("password");
        userDO.setUsername(username);
        userDO.setPassword(newPassword);
        userDO.setUserStatus("NORMAL");
        userDO.setSalt(salt);
        userService.save(userDO);
        resultData.setMsg("注册成功");
        resultData.setCode(RetCode.SUCCESS.getCode());
        return resultData;
    }

}
