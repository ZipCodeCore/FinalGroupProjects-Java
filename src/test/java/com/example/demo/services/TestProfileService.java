package com.example.demo.services;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.service.ProfileService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TestProfileService {

    @Mock
    ProfileRepo repository;

    @InjectMocks
    ProfileService service;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    public void createProfileTest() {
        Profile expectedProfile = new Profile();

        service.createProfile(expectedProfile);
        service.createProfile(expectedProfile);

        Mockito.verify(repository, Mockito.times(2)).save(Mockito.any(Profile.class));
    }

    @Test
    public void findByIdTest() {
        Long id = 5L;
        Profile expectedProfile = new Profile();
        expectedProfile.setId(id);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedProfile));
        Profile actualProfile = service.findById(id);

        Assert.assertEquals(expectedProfile.getId(), actualProfile.getId());
    }

    @Test
    public void findAllProfilesTest() {
        List<Profile> expectedProfiles = new ArrayList<>();
        expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile());

        Mockito.when(repository.findAll()).thenReturn(expectedProfiles);
        List<Profile> actualProfiles = service.findAllProfiles();

        Assert.assertEquals(expectedProfiles, actualProfiles);
    }

    @Test
    public void loginTest() {
        Profile profile = new Profile();
        String username = "test username";
        String password = "test password";
        profile.setUsername(username); profile.setPassword(password);

        Mockito.when(repository.findByUsername(username)).thenReturn(profile);
        service.login(username, password);
        service.login(username, password);

        Mockito.verify(repository, Mockito.times(2)).findByUsername(username);
    }

    @Test
    public void updateTest() {
        Profile expectedProfile = new Profile();
        expectedProfile.setUsername("test username");
        expectedProfile.setPassword("test password");

        Mockito.when(repository.save(expectedProfile)).thenReturn(expectedProfile);
        Profile actualProfile = service.update(expectedProfile);

        Assert.assertEquals(expectedProfile.getFirstName(), actualProfile.getFirstName());
    }

    @Test
    public void deleteByIdTest() {
        Profile profile = new Profile();
        Long id = 4L;
        profile.setId(id);

        service.deleteProfileById(id);
        service.deleteProfileById(id);

        Mockito.verify(repository, Mockito.times(2)).deleteById(id);
    }
}
