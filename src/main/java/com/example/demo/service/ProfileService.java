package com.example.demo.service;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepo repository;

    public Profile createProfile(Profile profile) {
//        Profile profile = new Profile();
//        profile.setFirstName(profileData.getFirstName());
//        profile.setLastName(profileData.getLastName());
//        profile.setUsername(profileData.getUsername());
//        profile.setPassword(passwordEncoder.encode(profileData.getPassword()));
//        profile.setEnabled(true);
//        profile.setEmail(profileData.getEmail());
        return repository.save(profile);
    }

    public Profile findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = repository.findByUsername(username);
        if (profile == null) {
            throw new UsernameNotFoundException("Profile with username " + username + " not found");
        }
        return profile;
    }

    public Profile findByUsername(String username) {
        Profile profile = repository.findByUsername(username);
        if (profile == null) {
            throw new UsernameNotFoundException("Profile with username " + username + " not found");
        }
        return profile;
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public List<Profile> findAllProfiles() {
        return repository.findAll();
    }

    public Profile update(Profile profileData) {
        return repository.save(profileData);
    }

    public void deleteProfileById(Long id) {
        repository.deleteById(id);
    }
}
