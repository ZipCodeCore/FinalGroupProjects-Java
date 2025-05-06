package com.example.demo.controllers;

import com.example.demo.controller.ProfileController;
import com.example.demo.models.Profile;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProfileController.class)
public class TestProfileController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProfileController controller;

    @Before
    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper = mapper;
    }

    private Profile profile = new Profile(2L, "", "Ben", "Smith", "Ben123", "secretpassword", "ben@gmail.com", true);
    private Profile profile1 = new Profile("Ben123", "secretpassword");

//    @Test
//    public void registerTest() throws Exception {
//        Mockito.when(controller.createProfile(Mockito.any(Profile.class))).thenReturn(ResponseEntity.class);
//
//        mockMvc.perform(post("/profile/register")
//            .contentType("application/json")
//            .content(objectMapper.writeValueAsString(profile)))
//            .andExpect(status().isOk());
//    }
}
