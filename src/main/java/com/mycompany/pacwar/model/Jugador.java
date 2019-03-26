/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class Jugador implements Serializable{
    public String name;
    public String lastName;
    private String email;
    public String nickName;
    public String password;
    
    public Jugador(){}

    public Jugador(String name, String lastName, String email, String nickName, String password) {
        this.name=name;
        this.lastName=lastName;
        this.nickName=nickName;
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

    public String getNickName() {
        return nickName;
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

    public void setNickName(String nikName) {
        this.nickName = nikName;
    }
    
    public void setIdSala(String password) {
        this.password = password;
    }
}