package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
public class Channel {
// Comment yo
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ChannelType type;
//    @ManyToMany(mappedBy = "channels", fetch = FetchType.LAZY)
//    private List<Profile> profileList;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Message> messages;

    public Channel() {
    }

//    public Channel(Long id, String name, ChannelType type, List<Profile> profileList, List<Message> messages) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.profileList = profileList;
//        this.messages = messages;
//    }


    public Channel(Long id, String name, ChannelType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Channel(String name, ChannelType type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Profile> getProfileList() {
//        return profileList;
//    }
//
//    public void setProfileList(List<Profile> profileList) {
//        this.profileList = profileList;
//    }
//
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }

    public ChannelType getType() {
        return type;
    }

    public void setType(ChannelType type) {
        this.type = type;
    }
}
