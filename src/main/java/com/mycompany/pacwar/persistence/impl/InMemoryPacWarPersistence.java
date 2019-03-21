/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence.impl;

<<<<<<< HEAD
import com.mycompany.pacwar.persistence.Jugador;
import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
=======
import com.mycompany.pacwar.model.Player;
import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.List;
>>>>>>> ba819d4d8cc0155e0a0dc3d23f7cafe1f9324033

/**
 *
 * @author Andres
 */
<<<<<<< HEAD
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
=======

public class InMemoryPacWarPersistence implements PacWarPersistence {

    private final List<Player> players = new ArrayList<>();

    public InMemoryPacWarPersistence() {
        //load data
        Player karen = new Player("Karen", "Mora", "karen.mora@mail.escuelaing.edu.co", "Karen20", "karen123");
        Player sergio = new Player("Sergio", "Pena", "sergio.pena@mail.escuelaing.edu.co", "checho98", "sergio123");
        Player andres = new Player("Andres", "Rodriguez", "andres.rodriguez-de@mail.escuelaing.edu.co", "dokgo boy", "andres123");
        players.add(karen);
        players.add(sergio);
        players.add(andres);
    }

    @Override
    public void addPlayer(String name, String lastname, String mail, String nick, String password) throws PacWarException {
        players.add(new Player(name, lastname, mail, nick, password));

    }

    @Override
    public void logIn(String nick, String pass) throws PacWarException {
        for (Player p : players) {

            if (nick.equals(p.getNick()) & pass.equals(p.getPassword())) {

            } else{
                throw new PacWarException("The user or password is incorrect.");
            }

        }
>>>>>>> ba819d4d8cc0155e0a0dc3d23f7cafe1f9324033
    }

    @Override
    public List<Jugador> getGamersSameSesion(String idSala) {
        return new ArrayList<Jugador>(jugadores.values());
    }

}
