package com.zyp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * create by
 *
 * @author zouyuanpeng
 * @date 2020/11/28 17:26
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void consumerMessage(Message<String> message){
        System.out.println("消费者2-----> 消费消息："+message.getPayload()+" \t serverPort: "+serverPort);
    }
}
