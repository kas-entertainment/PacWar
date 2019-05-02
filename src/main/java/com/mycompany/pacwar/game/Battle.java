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
    void removePlayerToTeam(Pacman pacman, int team) throws BattleException;
    ArrayList<Pacman> getAllPacmans();
    int findPacmanTeam(Pacman pacman)throws BattleException;
    Pacman getPacman(String username) throws BattleException;
    void insertPowerInBatlle(Power poder) throws BattleException;
    void removePowerFromBatle(Power poder) throws BattleException;
    ArrayList<Power> getAllPowers()throws BattleException;
    Power getPower(int idPoder)throws BattleException;
    void setId(int id);
    ArrayList<Pacman> getAllPacmansFromTeam(int team);
    void movePacman(String username,int key);
    
    
    
    ArrayList<Ghost> getAllGhost();
    int findGhostTeam(Ghost ghost)throws BattleException;
    Ghost getGhost(String username) throws BattleException;
    ArrayList<Ghost> getAllGhostsFromTeam(int team);
    void moveGhost(String username,int key);
}
