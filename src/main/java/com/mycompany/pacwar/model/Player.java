/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

/**
 *
<<<<<<< HEAD
 * @author 2110461
 */
public class Player extends Element{
    
    protected String name;
    protected String lastname;
    protected String mail;
    protected String nick;
    protected String password;

    public Player(String name, String lastname, String mail, String nick, String password) {
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.nick = nick;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
=======
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
>>>>>>> 1488700b950a7d06a1414d5cde36f2629674260c
}
