/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class Jugador implements Serializable{
    private String name;
    private String lastName;
    private String email;
    private String nikName;
    private String password;
    
    public Jugador(){}

    public Jugador(String name, String lastName, String nikName, String email, String password) {
        this.name=name;
        this.lastName=lastName;
        this.nikName=nikName;
        this.email=email;
        this.password=password;
    }
    
    
    
    public String getPassword(){
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNikName() {
        return nikName;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }
    
    public void setIdSala(String password) {
        this.password = password;
    }
}