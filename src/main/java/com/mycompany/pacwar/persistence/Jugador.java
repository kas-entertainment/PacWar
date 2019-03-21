/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class Jugador {
    private String name;
    private String lastName;
    private String email;
    private String nikName;
    private int puntos;
    private ArrayList poderes;
    private String idSala;

    public Jugador(String name, String lastName, String nikName, String email, String idSala, int puntos, ArrayList poderes) {
        this.name=name;
        this.lastName=lastName;
        this.nikName=nikName;
        this.email=email;
        this.idSala=idSala;
        this.puntos=puntos;
        this.poderes=poderes;
    }
    
    
    
    public String getIdSala(){
        return idSala;
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

    public int getPuntos() {
        return puntos;
    }

    public ArrayList getPoderes() {
        return poderes;
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

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPoderes(ArrayList poderes) {
        this.poderes = poderes;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }
}
