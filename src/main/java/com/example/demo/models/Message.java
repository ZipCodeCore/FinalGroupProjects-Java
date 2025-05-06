package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    Profile profile;
    String profileSentFrom;
    String body;
    String timestamp = new Date().toString();
    String channelName;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "channel_id", referencedColumnName = "id")
//    Channel channel;


    public Message() {
    }

    public Message(Long id, String profileSentFrom, String body, String timestamp, String channelName) {
        this.id = id;
        this.profileSentFrom = profileSentFrom;
        this.body = body;
        this.timestamp = timestamp;
        this.channelName = channelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProfileSentFrom() {
        return profileSentFrom;
    }

    public void setProfileSentFrom(String profileSentFrom) {
        this.profileSentFrom = profileSentFrom;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
