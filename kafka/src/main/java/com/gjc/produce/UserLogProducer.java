package com.gjc.produce;

import com.alibaba.fastjson.JSONObject;
import com.gjc.entity.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 生产者
 */
@Component
public class UserLogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendLog(String userId) {

        UserLog userLog = new UserLog();
        userLog.setUsername("gjc");
        userLog.setUserId(userId);
        userLog.setStatus("1");

        kafkaTemplate.send("test", JSONObject.toJSONString(userLog));
    }

}
