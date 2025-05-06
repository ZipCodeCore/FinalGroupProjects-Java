package com.example.demo.repository;

import com.example.demo.models.Channel;
import com.example.demo.models.ChannelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepo extends JpaRepository<Channel, Long> {
    List<Channel> findByType(ChannelType type);

    boolean existsByName(String name);

    Channel findByName(String name);
}
