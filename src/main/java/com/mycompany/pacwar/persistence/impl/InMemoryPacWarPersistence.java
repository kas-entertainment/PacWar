/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence.impl;

import com.mycompany.pacwar.model.Player;
import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */

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
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void addPlayer(String name, String lastname, String mail, String nick, String password) throws PacWarException {
        players.add(new Player(name, lastname, mail, nick, password));
    }
}