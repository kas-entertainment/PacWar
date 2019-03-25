/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

/**
 *
 * @author KAS
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
    private int team;
    private Power poder;
    
    
    public Pacman(int x, int y, String nick, int team){
        this.x=x;
        this.y = y;
        this.nick = nick; 
        this.team = team;
        this.poder = null;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public char getDirection() {
        return direction;
    }

    public Power getPoder() {
        return poder;
    }

    public void setPoder(Power poder) {
        this.poder = poder;
    }

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

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
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
