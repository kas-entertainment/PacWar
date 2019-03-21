/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.persistence.Jugador;
import com.mycompany.pacwar.services.pacWarServices;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author karen
 */
@RestController
@RequestMapping("/pacwar")
@Service
@Controller
public class PacWarAPIController {
    @Autowired
    private pacWarServices pacwarServices;
    
    //POST
    @RequestMapping(method = RequestMethod.POST, value ="/registrar")
    public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador){
        try{
            pacwarServices.addPlayer(jugador.getName(),jugador.getLastName(),jugador.getNikName(),jugador.getEmail(),jugador.getIdSala(),jugador.getPuntos(),jugador.getPoderes());
            return new ResponseEntity<>("Creado Correctamente",HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    
    //GET
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        try{
            return new ResponseEntity<> (pacwarServices.getAllGamers(),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("NO FUNCIONA",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/users/{nickName}", method = RequestMethod.GET)
    public ResponseEntity<?> getJugadorByName(@PathVariable String nickName){
        try{
            return new ResponseEntity<> (pacwarServices.getJugadorByName(nickName),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("NO FUNCIONA",HttpStatus.NOT_FOUND);
        }
    }
    
    
    //

}
