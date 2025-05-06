package com.example.demo.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestProfile {

    @Test
    public void nullableConstructorTest() {
        // Given
        Profile profile = new Profile();

        // Then
        Assert.assertNull(profile.getId()); Assert.assertNull(profile.getFirstName());
        Assert.assertNull(profile.getLastName()); Assert.assertNull(profile.getUsername());
        Assert.assertNull(profile.getPassword()); Assert.assertNull(profile.getEmail());
//        Assert.assertNull(profile.getChannels());
    }

    @Test
    public void constructorTest() {
        // Given
        Long expectedId = 1L;
        String expectedFirstName = "Ben";
        String expectedLastName = "Smith";
        String expectedUsername = "Batman";
        String expectedPassword = "Secret";
        String expectedEmail = "bens@gmail.com";
        List<Channel> expectedChannels = Stream.of(new Channel(), new Channel(), new Channel(), new Channel()).collect(Collectors.toList());
        List<Message> expectedMessages = Stream.of(new Message(), new Message(), new Message(), new Message()).collect(Collectors.toList());

        // When
        Profile profile = new Profile(expectedId, "", expectedFirstName, expectedLastName, expectedUsername, expectedPassword, expectedEmail, true);

        // Then
        Assert.assertEquals(expectedId, profile.getId()); Assert.assertEquals(expectedFirstName, profile.getFirstName());
        Assert.assertEquals(expectedLastName, profile.getLastName()); Assert.assertEquals(expectedUsername, profile.getUsername());
        Assert.assertEquals(expectedPassword, profile.getPassword()); Assert.assertEquals(expectedEmail, profile.getEmail());
//        Assert.assertEquals(expectedChannels, profile.getChannels());
    }

    @Test
    public void settersTest() {
        // Given
        Long expectedId = 1L;
        String expectedFirstName = "Ben";
        String expectedLastName = "Smith";
        String expectedUsername = "Batman";
        String expectedPassword = "Secret";
        String expectedEmail = "bens@gmail.com";
        List<Channel> expectedChannels = Stream.of(new Channel(), new Channel(), new Channel(), new Channel()).collect(Collectors.toList());
        List<Message> expectedMessages = Stream.of(new Message(), new Message(), new Message(), new Message()).collect(Collectors.toList());
        Profile profile = new Profile();

        // When
        profile.setId(expectedId);
        profile.setFirstName(expectedFirstName);
        profile.setLastName(expectedLastName);
        profile.setUsername(expectedUsername);
        profile.setPassword(expectedPassword);
        profile.setEmail(expectedEmail);
//        profile.setChannels(expectedChannels);

        // Then
        Assert.assertEquals(expectedId, profile.getId()); Assert.assertEquals(expectedFirstName, profile.getFirstName());
        Assert.assertEquals(expectedLastName, profile.getLastName()); Assert.assertEquals(expectedUsername, profile.getUsername());
        Assert.assertEquals(expectedPassword, profile.getPassword()); Assert.assertEquals(expectedEmail, profile.getEmail());
//        Assert.assertEquals(expectedChannels, profile.getChannels());
    }
}
