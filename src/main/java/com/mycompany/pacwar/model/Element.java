/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

/**
 *
 * @author Sergio
 */
public class Element {
    
    protected int id;
    protected int x,y;
    protected int tamX,tamY;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamX() {
        return tamX;
    }

    public void setTamX(int tamX) {
        this.tamX = tamX;
    }

    public int getTamY() {
        return tamY;
    }

    public void setTamY(int tamY) {
        this.tamY = tamY;
    }
    
    
}
