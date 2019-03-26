/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.services;

import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author karen
 */
@Service
public class pacWarServices {
    @Autowired
    PacWarPersistence pacwarPersistence;
    
    public void addPlayer(String name, String lastName, String email, String nikName, String password){
        pacwarPersistence.addPlayer(name, lastName, email, nikName,password);
    }
    public Jugador getJugadorByName(String nikName){
        return pacwarPersistence.getJugadorByName(nikName);
    }
    
    public List<Jugador> getAllGamers(){
        return pacwarPersistence.getAllGamers();
    }
    
    public List<Jugador> getGamersSameSesion(String idSala){
        return pacwarPersistence.getGamersSameSesion(idSala);
    }

    public void logIn(String nickname, String password) {
        pacwarPersistence.logIn(nickname,password);
    }
}