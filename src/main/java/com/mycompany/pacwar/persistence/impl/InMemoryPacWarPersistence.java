/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence.impl;

import com.mycompany.pacwar.game.BattleException;
import com.mycompany.pacwar.model.actors.Pacman;
import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Andres
 */
@Service
public class InMemoryPacWarPersistence implements PacWarPersistence{
    
    private final Map<String,Jugador> jugadores= new HashMap<String,Jugador>();
    
    
    public InMemoryPacWarPersistence(){
        String name="karen";
        String lastName="mora";
        String nickName="moris";
        String email="karen.mora@mai.escuelaing.edu.co";
        String password="12345";
        Jugador gamer = new Jugador(name, lastName, email, nickName, password);
        jugadores.put(nickName, gamer);
        
        String nameB="andres";
        String lastNameB="pkas";
        String nikNameB="andrew";
        String emailB="andres.mora@mai.escuelaing.edu.co";
        String passwordB="12345";
        Jugador gamerB= new Jugador(nameB, lastNameB,emailB ,nikNameB, passwordB);
        jugadores.put(nikNameB, gamerB);
        
        String nameC="sergio";
        String lastNameC="peña";
        String nikNameC="chechomon";
        String emailC="sergio.pena@mai.escuelaing.edu.co";
        String passwordC="12345";
        Jugador gamerC = new Jugador(nameC, lastNameC,emailC,nikNameC, passwordC);
        jugadores.put(nikNameC, gamerC);
        
    }

    @Override
    public void addPlayer(String name, String lastName, String email, String nikName, String password) {
        Jugador jugador=null;
        jugador=new Jugador(name,lastName,email,nikName,password);
        jugadores.put(nikName, jugador);
    }

    @Override
    public Jugador getJugadorByName(String nikName) {
        return jugadores.get(nikName);
    }

    @Override
    public List<Jugador> getAllGamers() {
        return new ArrayList<Jugador>(jugadores.values());
    }

    @Override
    public List<Jugador> getGamersSameSesion(String idSala) {
        return new ArrayList<Jugador>(jugadores.values());
    }

    @Override
    public void registerPlayerToRoom(int roomId, Pacman pacman, int team) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePlayerFromRoom(int roomId, Pacman pacman, int team) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Pacman> getRegisteredPlayers(int roomId) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createRoom(int roomId) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRoom(int roomId) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTotalRooms() throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePacman(int roomId, String username, int key, int team) throws com.mycompany.pacwar.game.PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playerOnline(int roomId, String username) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pacman getPlayer(int roomId, String username) throws BattleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> getRooms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logIn(String nickname, String password) {
        for(int i=0; i<jugadores.size();i++){
            if(jugadores.get(i).getNickName().equals(nickname)){
                break;
            }
        }
    }
}