/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence.impl;

import com.mycompany.pacwar.game.BattleException;
import com.mycompany.pacwar.model.Pacman;
import com.mycompany.pacwar.persistence.Jugador;
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
        String nikName="moris";
        String email="karen.mora@mai.escuelaing.edu.co";
        String idSala="101";
        int puntos=0;
        ArrayList poderes=null;
        Jugador gamer = new Jugador(name, lastName, nikName, email, idSala, puntos, poderes);
        jugadores.put(nikName, gamer);
        
        String nameB="andres";
        String lastNameB="pkas";
        String nikNameB="andrew";
        String emailB="andres.mora@mai.escuelaing.edu.co";
        String idSalaB="101";
        int puntosB=0;
        ArrayList poderesB=null;
        Jugador gamerB= new Jugador(nameB, lastNameB, nikNameB, emailB, idSalaB, puntosB, poderesB);
        jugadores.put(nikNameB, gamerB);
        
        String nameC="sergio";
        String lastNameC="peña";
        String nikNameC="chechomon";
        String emailC="sergio.pena@mai.escuelaing.edu.co";
        String idSalaC="101";
        int puntosC=0;
        ArrayList poderesC=null;
        Jugador gamerC = new Jugador(nameC, lastNameC, nikNameC, emailC, idSalaC, puntosC, poderesC);
        jugadores.put(nikNameC, gamerC);
        
    }

    @Override
    public void addPlayer(String name, String lastName, String nikName, String email, String idSala, int puntos, ArrayList poderes) {
        Jugador jugador=null;
        jugador=new Jugador(name, lastName, nikName,email, idSala, puntos,poderes);
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
    
}