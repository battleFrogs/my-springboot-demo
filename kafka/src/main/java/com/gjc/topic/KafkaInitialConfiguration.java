package com.gjc.topic;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaInitialConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    /*******************************第一种******************************************/

    /**
     * 创建TopicName为topic.quick.initial的Topic并设置分区数为8以及副本数为1
     * 构建Bean来创建
     * @return NewTopic
     */
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic.quick.initial", 8, (short) 1);
    }


    /*******************************第二种******************************************/

    /**
     * 代码中构建创建环境，后期直接调用创建topic
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = new HashMap<>();
        //配置Kafka实例的连接地址
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        return new KafkaAdmin(props);
    }

    /**
     * 构建client
     * 后面使用，NewTopic topic = new NewTopic("topic.quick.initial2", 1, (short) 1);
     *         adminClient.createTopics(Arrays.asList(topic));
     * @return AdminClient
     */
    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfig());
    }


    /*************************************************************************/


}
