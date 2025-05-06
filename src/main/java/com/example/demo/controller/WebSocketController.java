package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
        template.convertAndSend("/topic/message", message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload Message message) {
        // receive message from client
    }


    @SendTo("/topic/message")
    public Message broadcastMessage(@Payload Message message) {
        return message;
    }
}