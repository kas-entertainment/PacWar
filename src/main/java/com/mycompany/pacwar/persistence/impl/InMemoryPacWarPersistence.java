/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence.impl;

import com.mycompany.pacwar.persistence.PacWarException;
import com.mycompany.pacwar.persistence.PacWarPersistence;

/**
 * 
 * @author Andres
 */
public class InMemoryPacWarPersistence implements PacWarPersistence{
    
    @Override
    public void addPlayer(String name, String lastname, String mail, String nick, String password) throws PacWarException{
       
    }

    @Override
    public void logIn(String nick, String pass) throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logOut() throws PacWarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
