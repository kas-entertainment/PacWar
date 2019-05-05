package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.newModel.GHost;
import com.mycompany.pacwar.newModel.PacMan;
import com.mycompany.pacwar.services.PacWarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pacwar/game")
@Service
@Controller
public class PacWarGameRestController {
    @Autowired
    private PacWarServices pacwarServices;
    @Autowired
    PacWarMessageController pwmc;


    @RequestMapping(method = RequestMethod.POST, value ="/newroom")
    public ResponseEntity<?> createRoom(int id){
        try{
            pacwarServices.addRoom(id);
            return new ResponseEntity<>( HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/rooms")
    public ResponseEntity<?> getRooms(){
        try{
            return new ResponseEntity<>(pacwarServices.getRooms(), HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/{roomId}/pacman")
    public ResponseEntity<?> createPacMan(@PathVariable(name = "roomId")int roomId, @RequestBody PacMan pacMan){
        try{
            pwmc.newPacMan(pacwarServices.addPacMan(roomId,pacMan),roomId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/{roomId}/ghost")
    public ResponseEntity<?> createGhost(@PathVariable(name = "roomId")int roomId, @RequestBody GHost ghost, String name){
        try{
            pwmc.newGhost(pacwarServices.addGhost(roomId, ghost, name), roomId, name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{roomId}/pacmans")
    public ResponseEntity<?> getPacMans(@PathVariable(name = "roomId")int roomId){
        try{
            return new ResponseEntity<>(pacwarServices.getPacMans(roomId),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{roomId}/ghosts")
    public ResponseEntity<?> getGhosts(@PathVariable(name = "roomId")int roomId,String name){
        try{
            return new ResponseEntity<>(pacwarServices.getGhosts(roomId,name),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/{roomId}/backgrounditems")
    public ResponseEntity<?> getBackGroundItems(@PathVariable(name = "roomId")int roomId){
        try{
            return new ResponseEntity<>(pacwarServices.getBackGroundItemByRoomId(roomId),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
