/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

/**
 *
 * @author 2112076
 */
public class Player {
    String Name;
    String LastName;
    String Mail;
    String Nick;
    String Password;

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMail() {
        return Mail;
    }

    public String getNick() {
        return Nick;
    }

    public String getPassword() {
        return Password;
    }

    public Player(String Name, String LastName, String Mail, String Nick, String Password) {
        this.Name = Name;
        this.LastName = LastName;
        this.Mail = Mail;
        this.Nick = Nick;
        this.Password = Password;
    }
}
