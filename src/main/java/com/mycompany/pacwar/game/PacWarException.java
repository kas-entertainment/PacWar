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
public class PacWarException extends Exception{
    
    public PacWarException(String message) {
        super(message);
    }

    public PacWarException(String message, Throwable cause) {
        super(message, cause);
    }
}
