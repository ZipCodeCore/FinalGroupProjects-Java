package com.example.demo.service;

import com.example.demo.models.Channel;
import com.example.demo.models.ChannelType;
import com.example.demo.models.Profile;
import com.example.demo.repository.ChannelRepo;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    private ChannelRepo channelRepo;
    private ProfileRepo profileRepo;

    @Autowired
    public ChannelService(ChannelRepo channelRepo, ProfileRepo profileRepo) {
        this.channelRepo = channelRepo;
        this.profileRepo = profileRepo;
    }

    public Channel createChannel(Channel channel) {
        return channelRepo.save(channel);
    }

    public Channel readChannel(Long id) {
        return channelRepo.findById(id).get();
    }

    public List<Channel> readAllChannels() {
        Iterable<Channel> channelIterable = channelRepo.findAll();
        List<Channel> result = new ArrayList<>();
        channelIterable.forEach(result::add);
        return result;
    }

    public List<Channel> readAllChannelsByType(ChannelType type) {
        return channelRepo.findByType(type);
    }

    public boolean existsByName(String name) {
        return channelRepo.existsByName(name);
    }

    public Channel findByName(String name) {
        return channelRepo.findByName(name);
    }

//    public List<Channel> findByProfileUsername(String username) {
//        List<Channel> allChannels = readAllChannels();
//        return allChannels
//                .stream()
//                .filter(channel -> {
//                    List<Profile> profilesInChannel = channel.getProfileList();
//                    for (Profile profile : profilesInChannel) {
//                        if (profile.getUsername().equals(username)) {
//                            return true;
//                        }
//                    }
//                    return false;
//                })
//                .collect(Collectors.toList());
//
//    }

    public Channel update(Long id, Channel channel) {
        Channel channelInDb = readChannel(id);
        channelInDb.setId(channel.getId());
        channelInDb = channelRepo.save(channelInDb);
        return channelInDb;
    }

    public Channel delete(Long id) {
        Channel channelInDb = readChannel(id);
        channelRepo.delete(channelInDb);
        return channelInDb;
    }

    public Boolean deleteAllChannels() {
        readAllChannels().forEach(channel -> delete(channel.getId()));
        return true;
    }


}
