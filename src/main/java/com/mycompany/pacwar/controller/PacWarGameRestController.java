package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.model.Jugador;
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
        //System.out.println("1C. createPacMan PacWarGameRestController");
        try{
            pwmc.newPacMan(pacwarServices.addPacMan(roomId,pacMan),roomId);
            //System.out.println("2C. ENTRO AL TRY createPacMan PacWarGameRestController");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("2C. NTRO AL catch createPacMan PacWarGameRestController");
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{roomId}/pacmans")
    public ResponseEntity<?> getPacMans(@PathVariable(name = "roomId")int roomId){
        //System.out.println("3C. getPacMans PacWarGameRestController");
        try{
            return new ResponseEntity<>(pacwarServices.getPacMans(roomId),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PacWarAPIController.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("4C. catch getPacMans PacWarGameRestController");
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
