/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public interface PacWarPersistence {
    
    public void addPlayer(String name, String lastName, String nikName, String email, String idSala, int puntos, ArrayList poderes);

    public Jugador getJugadorByName(String nikName);

    public List<Jugador> getAllGamers();

    public List<Jugador> getGamersSameSesion(String idSala);
    

}
