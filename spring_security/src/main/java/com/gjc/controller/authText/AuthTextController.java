package com.gjc.controller.authText;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authText")
public class AuthTextController {

    /**
     * 拥有TEST权限的访问
     *
     * @return resultData
     */
    @PreAuthorize("hasRole('TEST')")
    @RequestMapping("/test")
    public ResultData test() {
        return new ResultData(RetCode.SUCCESS.getCode(), "拥有TEST权限的访问成功");
    }

    /**
     * 拥有TEST和DEVELOPER权限的访问
     *
     * @return resultData
     */
    @PreAuthorize("hasRole('TEST') and hasRole('DEVELOPER')")
    @RequestMapping("/testAndDeveloper")
    public ResultData testAndDeveloper() {
        return new ResultData(RetCode.SUCCESS.getCode(), "拥有TEST和DEVELOPER权限的访问成功");
    }

    /**
     * 拥有TEST或者DEVELOPER权限的访问
     *
     * @return resultData
     */
    @PreAuthorize("hasAnyRole('TEST','DEVELOPER')")
    @RequestMapping("/testOrDeveloper")
    public ResultData testOrDeveloper() {
        return new ResultData(RetCode.SUCCESS.getCode(), "拥有TEST或者DEVELOPER权限的访问成功");
    }

    /**
     * 拥有sys:user:info权限可以访问
     *
     * @return resultData
     */
    @PreAuthorize("hasPermission('/authText/permission','sys:user:info')")
    @RequestMapping("/permission")
    public ResultData permission() {
        return new ResultData(RetCode.SUCCESS.getCode(), "拥有sys:user:info权限的访问成功");
    }


    /**
     * 拥有TEST角色和sys:role:info权限可以访问
     *
     * @return resultData
     */
    @PreAuthorize("hasRole('TEST') and hasPermission('/authText/roleAndPermission','sys:user:info')")
    @RequestMapping("/roleAndPermission")
    public ResultData roleAndPermission() {
        return new ResultData(RetCode.SUCCESS.getCode(), "拥有TEST角色和sys:role:info权限可以访问");
    }

}
