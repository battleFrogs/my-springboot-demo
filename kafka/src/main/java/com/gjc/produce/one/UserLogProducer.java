package com.gjc.produce.one;

import com.alibaba.fastjson.JSONObject;
import com.gjc.entity.UserLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * 生产者
 */
@Component
public class UserLogProducer {

    private Logger log = LoggerFactory.getLogger(UserLogProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 点对点接收
     *
     * @param userId
     */
    public void sendLog(String userId) {

        UserLog userLog = new UserLog();
        userLog.setUsername("gjc");
        userLog.setUserId(userId);
        userLog.setStatus("1");


        /**
         * 异步获取消息发送的结果
         * 获取结果的消息
         */
        ListenableFuture<SendResult<String, Object>> sendResult = kafkaTemplate.send("test", JSONObject.toJSONString(userLog));
        sendResult.addCallback(result -> log.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));

    }

}
