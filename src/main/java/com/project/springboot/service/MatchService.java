package com.project.springboot.service;

import com.project.springboot.model.MatchPayload;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    public MatchPayload getliveScore(){

        MatchPayload payloadObj = new MatchPayload(1,"AUS","IND",200,201,"Ind win the match");

        return payloadObj;

    }

}
