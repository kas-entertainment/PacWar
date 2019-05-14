package com.mycompany.pacwar.services;

import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.newModel.BackGroundItem;
import com.mycompany.pacwar.newModel.PacMan;
import com.mycompany.pacwar.newModel.Room;

import java.util.ArrayList;
import java.util.List;

public interface PacWarServices {


    ArrayList<PacMan> getPacMans(int room);
    
    ArrayList<Room> getRooms();

    Room getRoom(int id);

    PacMan addPacMan(int roomId, PacMan pacMan);

    void addRoom(int id);

    void movePacMan(String id, int key, int room);

    ArrayList<BackGroundItem> getBackGroundItemByRoomId(int idRoom);

    public void removeRoom(int roomId);
    
}