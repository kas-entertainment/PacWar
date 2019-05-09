package com.mycompany.pacwar.controller;

import com.mycompany.pacwar.newModel.Dot;
import com.mycompany.pacwar.newModel.GHost;
import com.mycompany.pacwar.newModel.PacMan;
import com.mycompany.pacwar.services.PacWarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@Service
public class PacWarMessageController {

    @Autowired
    PacWarServices pacwarServices;

    @Autowired
    SimpMessagingTemplate smt;

    @MessageMapping("/move.{room}")
    public void move(Move move, @DestinationVariable int room){
        pacwarServices.movePacMan(move.id,move.key,room);
        pacwarServices.moveGhost(move.id,move.key,room);
    }

    @MessageMapping("/newpacman.{room}")
    public void newPacMan(PacMan pacMan,@DestinationVariable int room){
        //System.out.println("1.1C. newPacMan PacWarMessageController");
        smt.convertAndSend("/topic/newpacman."+room, pacMan);
    }
    
    @MessageMapping("/newghost.{room}")
    public void newGhost(GHost ghost,@DestinationVariable int room){
        System.out.println("1.1G. newghost PacWarMessageController");
        smt.convertAndSend("/topic/newghost."+room, ghost);
    }
    
            
    
    /*
    @MessageMapping("/newpacman.{room}")
    public void newGhost(Ghost ghost,@DestinationVariable int room){
        smt.convertAndSend("/topic/newpacman."+room, ghost);
    }
    
    public void sendMovementGhost(Ghost ghost, int room){
        smt.convertAndSend("/topic/move."+room,ghost);
    }
    
    */
    

    public void sendMovementPacMan(PacMan pacMan, int room){
        //System.out.println("5C. sendMovementPacMan PacWarMessageController");
        smt.convertAndSend("/topic/move."+room,pacMan);
    }

    public void sendDeleteDot(Dot dot, int room){
        smt.convertAndSend("/topic/deletedot."+room,dot);
    }

    public void sendMovementGhost(GHost moveGHost, int room) {
        System.out.println("7G. sendMovementGhost PacWarMessageController");
        smt.convertAndSend("/topic/move."+room,moveGHost);
    }

    static class Move{
        private String id;
        private int key;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
}


