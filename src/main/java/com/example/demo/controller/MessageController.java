package com.example.demo.controller;

import com.example.demo.models.Message;
import com.example.demo.repository.MessageRepo;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;

    }

   @PostMapping(value = "/create")
    public ResponseEntity<Message> create(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    @GetMapping("/find/{channelName}")
    public ResponseEntity<List<Message>> findByChannelName(@PathVariable String channelName) {
        return new ResponseEntity<>(messageService.findByChannelName(channelName), HttpStatus.OK);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Message> read(@PathVariable Long id ){
        return new ResponseEntity<>(messageService.read(id), HttpStatus.OK);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Message>> readAll(){
        return new ResponseEntity<>(messageService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update{id}")
    public ResponseEntity<Message> update (@PathVariable Long id, @RequestBody Message newMessageData){
        return new ResponseEntity<>(messageService.update(id, newMessageData), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete{id}")
    public ResponseEntity<Message> delete(@PathVariable Long id ){
        return new ResponseEntity<>(messageService.delete(id), HttpStatus.OK);
    }


}