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
public class TeamGhost {
    private int Score;
    private int number;
    private ConcurrentHashMap<String,Ghost> ghosts = new ConcurrentHashMap<>();

    public TeamGhost(int number) {
        Score = 0;
        this.number = number;
    }
    
    public void addPacman(Ghost ghost) throws GameException{
        if(ghosts.size()>20){
            throw new GameException("This Team is Full");
        }
        else {
            ghosts.put(ghost.getUsername(), ghost);
        }
    }
    
    public void removeGhost(String username) throws GameException{
        if(!ghosts.containsKey(username)){
            throw new GameException("This team does not contain this player");
        }
        else {
            ghosts.remove(username);
        }
    }
    
    public Ghost getGhost(String username)throws GameException{
        if(!ghosts.containsKey(username)){
            throw new GameException("That pacman does not exist");
        }
        else{
            return ghosts.get(username);
        }
    }
    
    public boolean isInTeam(String username){
        if(ghosts.containsKey(username)){
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

    public ArrayList<Ghost> getGhosts() {
        return new ArrayList<Ghost>(ghosts.values());
    }
    
}
