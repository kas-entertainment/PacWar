/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.game.PacWarException;
import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.mongodb.User;
import com.mycompany.pacwar.mongodb.UserRepository;
import com.mycompany.pacwar.services.PacWarServices;

import java.util.Optional;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    UserRepository ur;

    //POST
    @RequestMapping(method = RequestMethod.POST, value ="/register")
    public ResponseEntity<?> crearJugador(@RequestBody User user){
        try{
            if(ur.findById(user.id).equals(Optional.empty())) {
                ur.save(user);
            }else{
                throw new PacWarException("User already exists");
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value ="/{nickname}/{password}")
    public ResponseEntity<?> logIn(@PathVariable String nickname, @PathVariable String password){
        try{
            return new ResponseEntity<>(ur.findByIdAndPassword(nickname,password),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    

    
    


}