package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean enabled = true;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(joinColumns = @JoinColumn(name = "profile_id"),
//               inverseJoinColumns = @JoinColumn(name = "channel_id"))
//    private List<Channel> channels;
//    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
//    private List<Message> messages;

    public Profile() {
    }

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Profile(Long id, String token, String firstName, String lastName, String username, String password, String email, boolean enabled) {
        this.id = id;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }
    //    public Profile(Long id, String token, String firstName, String lastName, String username, String password, String email, boolean enabled, List<Channel> channels) {
//        this.id = id;
//        this.token = token;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.enabled = enabled;
//        this.channels = channels;
//    }
//
//    public Profile(Long id, String token, String firstName, String lastName, String username, String password, String email, boolean enabled, List<Channel> channels, List<Message> messages) {
//        this.id = id;
//        this.token = token;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.enabled = enabled;
//        this.channels = channels;
//        this.messages = messages;
//    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public List<Channel> getChannels() {
//        return channels;
//    }
//
//    public void setChannels(List<Channel> channels) {
//        this.channels = channels;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
}
