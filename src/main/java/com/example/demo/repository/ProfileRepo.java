package com.example.demo.repository;

import com.example.demo.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
//    Profile findByUsernameAndPassword(String username, String password);

    Profile findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
