/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Sergio
 */
public class Team {
    private int Score;
    private int number;
    private ConcurrentHashMap<String,Pacman> pacmans = new ConcurrentHashMap<>();

    public Team(int number) {
        Score = 0;
        this.number = number;
    }
    
    public void addPlayer(Pacman pacman) throws GameException{
        if(pacmans.size()>6){
            throw new GameException("This Team is Full");
        }
        else {
            pacmans.put(pacman.getNick(), pacman);
        }
    }
    
    public void removePlayer(String username) throws GameException{
        if(!pacmans.containsKey(username)){
            throw new GameException("This team does not contain this player");
        }
        else {
            pacmans.remove(username);
        }
    }
    
    public Pacman getPacman(String username)throws GameException{
        if(!pacmans.containsKey(username)){
            throw new GameException("That pacman does not exist");
        }
        else{
            return pacmans.get(username);
        }
    }
    
    public boolean isInTeam(String username){
        if(pacmans.containsKey(username)){
            return true;
        }
        else{
            return false;
        }
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Pacman> getGhosts() {
        return new ArrayList<Pacman>(pacmans.values());
    }
    
}
