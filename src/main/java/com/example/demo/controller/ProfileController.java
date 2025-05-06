package com.example.demo.controller;

import com.example.demo.models.Profile;
import com.example.demo.security.JwtGenerator;
import com.example.demo.security.LoginRequest;
import com.example.demo.security.LoginResponse;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtGenerator jwtGenerator;

    @Autowired
    ProfileService service;

    @PostMapping(value = "/register")
    public ResponseEntity<?> createProfile(@RequestBody Profile profile) {
        if (service.existsByUsername(profile.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.OK);
        }
        if (service.existsByEmail(profile.getEmail())) {
            return new ResponseEntity<>("Email is taken", HttpStatus.OK);
        }
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        return new ResponseEntity<>(service.createProfile(profile), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Profile>> findAllProfiles() {
        return new ResponseEntity<>(service.findAllProfiles(), HttpStatus.OK);
    }

    @PostMapping(value = "/login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(username);
        Profile profile = service.findByUsername(username);
        return new ResponseEntity<>(new LoginResponse(profile.getId(),
                token, profile.getFirstName(), profile.getLastName(),
                profile.getUsername(), profile.getEmail()
                ), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(service.update(profile), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteProfileById(id);
        return new ResponseEntity<>("Your Profile Has Been Deleted", HttpStatus.OK);
    }
}
