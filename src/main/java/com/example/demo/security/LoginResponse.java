package com.example.demo.security;

import com.example.demo.models.Channel;
import com.example.demo.models.Message;

import java.util.List;

public class LoginResponse {

    private Long id;
    private String token;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private List<Channel> channels;

    public LoginResponse(Long id, String token, String firstName, String lastName, String username, String email, List<Channel> channels) {
        this.id = id;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.channels = channels;
    }

    public LoginResponse(Long id, String token, String firstName, String lastName, String username, String email) {
        this.id = id;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}
