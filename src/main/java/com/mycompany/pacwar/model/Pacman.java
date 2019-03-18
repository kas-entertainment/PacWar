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
public class Pacman {
    private int x,y;
    private int health = 100;
    public static final int velocity = 10;
    public static final int pacmanSize = 50;
    public static final int BOUNDX = 100;
    public static final int BOUNDY = 100;
    private char direction = 'U';
    private int online = 100;
    private String nick;
    //private Poder poder;
    
    
    public Pacman(int x, int y, String nick){
        this.x=x;
        this.y = y;
        this.nick = nick; 
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static int getVelocity() {
        return velocity;
    }

    public static int getPacmanSize() {
        return pacmanSize;
    }

    public static int getBOUNDX() {
        return BOUNDX;
    }

    public static int getBOUNDY() {
        return BOUNDY;
    }
    
    public void damage(int damage){
        this.health-=damage;

    }
    
    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
    
    public void move(int key){
        switch (key) {
            case 37:
                if(x>0) x-=velocity;
                direction = 'L';
                break;
            case 38:
                if(y>0) y-=velocity;
                direction = 'U';
                break;
            case 39:
                if(x<830) x+=velocity;
                direction = 'R';
                break;
            case 40:
                if(y<470) y+=velocity;
                direction = 'D';
                break;
            default:
                break;
        }
    }
    
    public synchronized void isOnline(){
        online = 100;
    }
    
    public synchronized boolean notOnline(){
        online -= 1;
        if(online <= 0){
            return true;
        }else{
            return false;
        }
    }
    
    
}
