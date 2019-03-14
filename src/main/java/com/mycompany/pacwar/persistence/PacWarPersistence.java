/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

/**
 *
 * @author Andres
 */
public interface PacWarPersistence {
    public void addPlayer(String name,String lastname,String mail,String nick,String password) throws PacWarException;
    public void logIn(String nick,String pass) throws PacWarException;
    public void logOut()throws PacWarException;
}
