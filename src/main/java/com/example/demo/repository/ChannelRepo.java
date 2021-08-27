package com.example.demo.repository;

import com.example.demo.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepo extends JpaRepository<Channel, Long> {
}
