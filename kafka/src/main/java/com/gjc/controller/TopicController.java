package com.gjc.controller;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/topic")
public class TopicController {


    @Resource
    private AdminClient adminClient;


    /**
     * 查询主题信息
     * @param topicName 主题名称
     * @return ResultData
     */
    @RequestMapping("/getTopicInfo")
    public ResultData getTopicInfo(String topicName) throws ExecutionException, InterruptedException {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Arrays.asList(topicName));
        Map<String, TopicDescription> stringTopicDescriptionMap = describeTopicsResult.all().get();
        resultData.setMsg("查询主题成功");
        resultData.setCode(RetCode.SUCCESS.getCode());
        resultData.addData("result", stringTopicDescriptionMap);
        return resultData;
    }

    /**
     * 创建主题信息
     * @param topicName 主题名称
     * @return ResultData
     */
    public ResultData createTopic(String topicName) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        NewTopic topic = new NewTopic(topicName, 1, (short) 1);
        adminClient.createTopics(Arrays.asList(topic));
        return resultData;
    }
}
