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
public interface PacWar {
    void insertRoom(int roomid,Battle bg) throws PacWarException;
    void removeRoom(int roomid) throws PacWarException;
    //void registerPlayerToRoom(int roomId, Pacman pacman, int team) throws PacWarException;
    //void removePlayerToRoom(int roomId, Pacman pacman, int team) throws PacWarException;
    void registerPlayerToRoom(int roomId, Pacman pacman,int team) throws PacWarException;
    void removePlayerToRoom(int roomId, Pacman pacman,int team) throws PacWarException;
    
    void registerPlayerToRoom(int roomId, Ghost ghost,int team) throws PacWarException;
    void removePlayerToRoom(int roomId, Ghost ghost,int team) throws PacWarException;
    
    HashMap<Integer, Battle> getRoomsMap();
    public Pacman getPacman(String username,int roomId,int team)throws PacWarException;
    public Ghost getGhost(String username,int roomId,int team)throws PacWarException;
    public Battle getRoom(int roomId)throws PacWarException;
    boolean containsRoom(int roomid);
    int getNextTeam(int roomId);
}
