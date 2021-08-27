package com.example.demo.service;

import com.example.demo.models.Message;
import com.example.demo.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageService {
    private MessageRepo messageRepo;


    @Autowired
    public MessageService(MessageRepo messageRepo){
        this.messageRepo = messageRepo;
    }


    public Message create (Message message){
        return messageRepo.save(message);
    }

    public Message read(Long id){
        return messageRepo.getById(id);
    }

    public List<Message> readAll(){
        return messageRepo.findAll();
    }

    public Message update(Long id, Message newMessageData){
        Message messageInDB = read(id);
        messageInDB.setBody(newMessageData.getBody());
        messageInDB.setProfile(newMessageData.getProfile());
        messageInDB.setTimestamp(newMessageData.getTimestamp());
        messageRepo.save(messageInDB);
        return messageInDB;
    }

    public Message delete(Long id){
        Message messageInDB = read(id);
            messageRepo.delete(messageInDB);
            return messageInDB;
        }

        public void deleteAll(){
        messageRepo.deleteAll();
    }



}
