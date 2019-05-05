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
    public GHost moveGHost(String id, int key, int idRoom) {
        GHost ghost = null;
        for(Room r:rooms){
            if(r.getIdRoom()==idRoom){
                ghost = r.moveGHost(id,key);
                break;
            }
        }
        return ghost;
    }

}
