package com.mycompany.pacwar.newModel;

import com.mycompany.pacwar.controller.PacWarMessageController;
import org.springframework.beans.factory.annotation.Autowired;

public class Dot extends Element implements BackGroundItem{

    private int size = BackGroundItem.getSize();

    private String type = "Dot";

    private String id;

    private boolean capture = false;

    private Room room;

    @Autowired
    PacWarMessageController pwmc;

    public Dot(){
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
                room.removeDot(this);
                pacMan.addPoints();
            }
        }
        return true;
    }
    
    
    
    @Override
    public boolean doesMove(GHost ghost, int key) {
        if(!capture) {
            boolean touch = false;
            if (key == 37) {//LEFT
                if (Block.colision(ghost.posX - ghost.velocity, ghost.posY, ghost.posX + ghost.size - ghost.velocity, ghost.posY + ghost.size, posX, posY, posX + size, posY + size))
                    touch = true;
            } else if (key == 38) {//UP
                if (Block.colision(ghost.posX, ghost.posY - ghost.velocity, ghost.posX + ghost.size, ghost.posY + ghost.size - ghost.velocity, posX, posY, posX + size, posY + size))
                    touch = true;
            } else if (key == 39) {//RIGHT
                if (Block.colision(ghost.posX + ghost.velocity, ghost.posY, ghost.posX + ghost.size + ghost.velocity, ghost.posY + ghost.size, posX, posY, posX + size, posY + size))
                    touch = true;
            } else {//DOWN
                if (Block.colision(ghost.posX, ghost.posY + ghost.velocity, ghost.posX + ghost.size, ghost.posY + ghost.size + ghost.velocity, posX, posY, posX + size, posY + size))
                    touch = true;
            }
            if(touch){
                capture = true;
                room.removeDot(this);
                ghost.addPoints();
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
