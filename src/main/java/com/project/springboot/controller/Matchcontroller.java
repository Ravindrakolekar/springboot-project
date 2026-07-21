package com.project.springboot.controller;

import com.project.springboot.model.MatchPayload;
import com.project.springboot.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Matchcontroller {


    @Autowired
    private MatchService matchService;

    @GetMapping("/liveScore")
    public MatchPayload getliveScore(){

        return matchService.getliveScore();

    }
}
