package com.example.demo.controller;

import com.example.demo.models.Channel;
import com.example.demo.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/channel-controller")
public class ChannelController {
    @Autowired
    private ChannelService service;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return new ResponseEntity<>(service.createChannel(channel), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{id}")
    public ResponseEntity<Channel> readChannel(@PathVariable Long id) {
        if(service.readChannel(id) != null){
            return new ResponseEntity<>(service.readChannel(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.readChannel(id),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable String name) {
        return new ResponseEntity<>(service.existsByName(name), HttpStatus.OK);
    }

    @GetMapping("find/{name}")
    public ResponseEntity<Channel> findByName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readAll")
    public ResponseEntity<List<Channel>> readAllChannels() {
        return new ResponseEntity<>(service.readAllChannels(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Channel> update(@PathVariable Long id,@RequestBody Channel channel) {
        if(service.readChannel(id) != null) {
            return new ResponseEntity<>(service.update(id, channel), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.createChannel(channel), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Channel> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }
}
