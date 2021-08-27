package com.example.demo.config;

import com.example.demo.models.Channel;
import com.example.demo.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ChannelConfig {
    @Autowired
    private ChannelService service;

    @PostConstruct
    public void setup() {
        service.createChannel(new Channel());
        service.createChannel(new Channel());
        service.createChannel(new Channel());
    }
}
