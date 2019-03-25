/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import com.mycompany.pacwar.game.BattleException;
import com.mycompany.pacwar.model.actors.Pacman;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andres
 */
public interface PacWarPersistence {
    
    public void addPlayer(String name, String lastName, String nikName, String email, String password);

    public Jugador getJugadorByName(String nikName);

    public List<Jugador> getAllGamers();

    public List<Jugador> getGamersSameSesion(String idSala);
    
    public void registerPlayerToRoom(int roomId,Pacman pacman,int team) throws BattleException;
    public void removePlayerFromRoom(int roomId,Pacman pacman,int team) throws BattleException;
    public Set<Pacman> getRegisteredPlayers(int roomId) throws BattleException;
    public void createRoom(int roomId) throws BattleException;
    public void removeRoom(int roomId) throws BattleException;
    public int getTotalRooms() throws BattleException;
    public void movePacman(int roomId, String username, int key,int team) throws com.mycompany.pacwar.game.PacWarException ;
    public void playerOnline(int roomId, String username)throws BattleException;
    public Pacman getPlayer(int roomId, String username) throws BattleException;
    public Set<Integer> getRooms();

    public void logIn(String nickname, String password);

}