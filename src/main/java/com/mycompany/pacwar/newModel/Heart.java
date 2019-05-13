package com.mycompany.pacwar.newModel;

import com.mycompany.pacwar.controller.PacWarMessageController;
import org.springframework.beans.factory.annotation.Autowired;

public class Heart extends Element implements BackGroundItem{
    
    private int size = BackGroundItem.getSize();
    
    private String type = "Heart";
    
    private String id;

    private boolean capture = false;

    private Room room;
    
    
    @Autowired
    PacWarMessageController pwmc;
    
    public Heart(){
        id = type + (int) (Math.random()*10000)+1;
    }
    
    @Override
    public boolean doesMove(PacMan pacMan, int key) {
        if(!capture) {
            boolean touch = false;
            if (key == 37) {//LEFT
                if (Block.colision(pacMan.posX - PacMan.velocity, pacMan.posY, pacMan.posX + PacMan.size - PacMan.velocity, pacMan.posY + PacMan.size, posX, posY, posX + size, posY + size))
                    touch = true;
            } else if (key == 38) {//UP
                if (Block.colision(pacMan.posX, pacMan.posY - PacMan.velocity, pacMan.posX + PacMan.size, pacMan.posY + PacMan.size - PacMan.velocity, posX, posY, posX + size, posY + size))
                    touch = true;
            } else if (key == 39) {//RIGHT
                if (Block.colision(pacMan.posX + PacMan.velocity, pacMan.posY, pacMan.posX + PacMan.size + PacMan.velocity, pacMan.posY + PacMan.size, posX, posY, posX + size, posY + size))
                    touch = true;
            } else {//DOWN
                if (Block.colision(pacMan.posX, pacMan.posY + PacMan.velocity, pacMan.posX + PacMan.size, pacMan.posY + PacMan.size + PacMan.velocity, posX, posY, posX + size, posY + size))
                    touch = true;
            }
            if(touch){
                capture = true;
                room.removeHeart(this);
                pacMan.addHealth();
            }
        }
        return true;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean getVisible() {
        return !capture;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
   
}
