package com.mycompany.pacwar.newModel;


import com.mycompany.pacwar.controller.PacWarMessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MainImpl implements Main{
    private ArrayList<Room> rooms = new ArrayList<>();

    @Autowired
    PacWarMessageController pwmc;

    @Override
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public Room getRoom(int id) {
        Room room = null;
        for(Room r:rooms){
            if(r.getIdRoom()==id) room = r;
        }
        return room;
    }

    @Override
    public void createRoom(int id) {
        Room room = new Room();
        room.setIdRoom(id);
        room.setMain(this);
        rooms.add(room);
    }

    @Override
    public PacMan movePacMan(String id, int key, int idRoom) {
        PacMan pacMan = null;
        for(Room r:rooms){
            if(r.getIdRoom()==idRoom){
                pacMan = r.movePacMan(id,key);
                break;
            }
        }
        return pacMan;
    }
    
    @Override
    public ArrayList<BackGroundItem> getBackGroundItems(int idRoom) {
        ArrayList<BackGroundItem> backGroundItems = null;
        for(Room r:rooms){
            if(r.getIdRoom()==idRoom){
                backGroundItems = r.getBackGroundItems();

            }
        }
        return backGroundItems;
    }
    
    
    @Override
    public void eliminateDot(Dot dot, int idRoom) {
        pwmc.sendDeleteDot(dot,idRoom);
    }

    @Override
    public void eliminateHeart(Heart heart, int idRoom) {
        pwmc.sendDeleteHeart(heart,idRoom);
    }

    @Override
    public void eliminateStar(Star star, int idRoom) {
        pwmc.sendDeleteStar(star,idRoom);
    }
    
    @Override
    public void eliminatePacMan(PacMan pacman, int idRoom) {
        pwmc.sendDeletePacMan(pacman,idRoom);
    }

    @Override
    public void eliminateRoom(int idRoom) {
        pwmc.sendDeleteRoom(idRoom);
    }

    @Override
    public void removeRoom(int roomId) {
        rooms.remove(roomId);
    }
    
    

}
