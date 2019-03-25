/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.game;

import com.mycompany.pacwar.model.actors.Pacman;
import com.mycompany.pacwar.controller.PacWarAPIController;
import com.mycompany.pacwar.model.*;
import java.util.*;

/**
 *
 * @author Sergio
 */
public class BattleImpl extends Thread implements Battle{
    
    private ArrayList<Food> comida;
    private ArrayList<Power> poderes = new ArrayList<Power>();
    private  int id;
    private final int numberOfTeams= 2;
    PacWarAPIController pwc;
    private boolean active=true;

    @Override
    public void insertPlayerToTeam(Pacman pacman, int team) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePlayerToTeam(Pacman pacman, int team) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pacman> getAllPacmans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findPacmanTeam(Pacman pacman) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pacman getPacman(String username) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertPowerInBatlle(Power poder) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePowerFromBatle(Power poder) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Power> getAllPowers() throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power getPower(int idPoder) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pacman> getAllPacmansFromTeam(int team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePacman(String username, int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
