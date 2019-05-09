/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.game;

import com.mycompany.pacwar.model.actors.Pacman;
import com.mycompany.pacwar.model.*;
import com.mycompany.pacwar.model.actors.Ghost;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface Battle {
    void insertPlayerToTeam(Pacman pacman, int team) throws BattleException;
    void insertPlayerToTeam(Ghost ghost, int team) throws BattleException;
    
    void removePlayerToTeam(Pacman pacman, int team) throws BattleException;
    void removePlayerToTeam(Ghost ghost, int team) throws BattleException;
    
    ArrayList<Pacman> getAllPacmans();
    ArrayList<Ghost> getAllGhost();
    
    int findPacmanTeam(Pacman pacman)throws BattleException;
    int findGhostTeam(Ghost ghost)throws BattleException;
     
    Pacman getPacman(String username) throws BattleException;
    Ghost getGhost(String username) throws BattleException;
    
    void insertPowerInBatlle(Power poder) throws BattleException;
    void removePowerFromBatle(Power poder) throws BattleException;
    ArrayList<Power> getAllPowers()throws BattleException;
    Power getPower(int idPoder)throws BattleException;
    void setId(int id);
    
    ArrayList<Pacman> getAllPacmansFromTeam(int team);
    ArrayList<Ghost> getAllGhostsFromTeam(int team);
    
    void movePacman(String username,int key);
    void moveGhost(String username,int key);
}
