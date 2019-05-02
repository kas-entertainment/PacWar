/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.game;

import com.mycompany.pacwar.model.actors.Ghost;
import com.mycompany.pacwar.model.actors.Pacman;
import java.util.HashMap;

/**
 *
 * @author Sergio
 */
public class PacWarImpl implements PacWar{
    

    @Override
    public void insertRoom(int roomid, Battle bg) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRoom(int roomid) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    @Override
    public void registerPlayerToRoom(int roomId, Pacman pacman, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePlayerToRoom(int roomId, Pacman pacman, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    @Override
    public HashMap<Integer, Battle> getRoomsMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pacman getPacman(String username, int roomId, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Battle getRoom(int roomId) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsRoom(int roomid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNextTeam(int roomId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void registerPlayerToRoom(int roomId, Pacman pacman, Ghost gost, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePlayerToRoom(int roomId, Pacman pacman, Ghost gost, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ghost getGhost(String username, int roomId, int team) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
