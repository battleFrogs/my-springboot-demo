package com.gjc.controller;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import com.gjc.produce.one.UserLogProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sendMessage")
public class SendMessageController {


    @Resource
    private UserLogProducer userLogProducer;

    /**
     * 点对点模式
     * @param userId
     * @return
     */
    @RequestMapping("/sendToTest")
    public ResultData sendToTest(String userId) {

        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        userLogProducer.sendLog(userId);
        resultData.setMsg("发送成功");
        resultData.setCode(RetCode.SUCCESS.getCode());
        return resultData;
    }
}
