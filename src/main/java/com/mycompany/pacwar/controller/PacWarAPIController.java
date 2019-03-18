/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author karen
 */
@RestController
@RequestMapping(value="/packwar")
public class PacWarAPIController {
    //@Autowired
    //private pacWarServices pcwServices;
    /*
    @RequestMapping(method = RequestMethod.POST, value ="/registrar")
    public ResponseEntity<?> crearJugador(@RequestBody Jugador jugador){
        try{
            pcwServices.crearJugador(jugador.getName(),jugador.getLastName(),jugador.getNikName(),jugador.getEmail(),jugador.getIdSala(),jugador.getPuntos(),jugador.getPoderes());
            return new ResponseEntity<>("Creado Correctamente",HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }*/
}
