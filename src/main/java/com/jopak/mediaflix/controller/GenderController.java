package com.jopak.mediaflix.controller;

import com.jopak.mediaflix.model.Gender;
import com.jopak.mediaflix.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    GenderRepository genderRepository;
    @PostMapping
    public void createGender(@RequestBody String genderName){
        Gender newGender = new Gender(genderName);
        genderRepository.save(newGender);
    }
}
