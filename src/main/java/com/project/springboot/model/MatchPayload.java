package com.project.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MatchPayload {

    @Id
    private int id;
    private String teamAName;
    private String teamBName;
    private int teamAscore;
    private int teamBScore;
    private String result;


    public MatchPayload(int id, String teamAName, String teamBName, int teamAscore, int teamBScore, String result) {
        this.id = id;
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAscore = teamAscore;
        this.teamBScore = teamBScore;
        this.result = result;
    }

    public MatchPayload() {

    }


    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public int getTeamAscore() {
        return teamAscore;
    }

    public void setTeamAscore(int teamAscore) {
        this.teamAscore = teamAscore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
