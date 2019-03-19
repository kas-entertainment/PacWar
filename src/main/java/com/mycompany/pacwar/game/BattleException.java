/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.game;

/**
 *
 * @author Sergio
 */
public class BattleException extends Exception{
    
    public BattleException(String message) {
        super(message);
    }

    public BattleException(String message, Throwable cause) {
        super(message, cause);
    }
}
