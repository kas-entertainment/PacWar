/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.model.Player;
import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karen
 */
@RestController
@RequestMapping(value="/packwar")
public class PacWarAPI {
     //@Autowired
    private PacWarPersistence pcwServices;
    @RequestMapping(method = RequestMethod.POST, value ="/registrar")
    public ResponseEntity<?> crearJugador(@RequestBody Player jugador){
        try{
            pcwServices.addPlayer(jugador.getName(),jugador.getLastname(),jugador.getMail(),jugador.getNick(),jugador.getPassword());
            return new ResponseEntity<>("Creado Correctamente",HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
