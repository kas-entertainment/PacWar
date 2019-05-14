/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.services.impl;

import com.mycompany.pacwar.controller.PacWarMessageController;
import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.newModel.BackGroundItem;
import com.mycompany.pacwar.newModel.Main;
import com.mycompany.pacwar.newModel.PacMan;
import com.mycompany.pacwar.newModel.Room;
import com.mycompany.pacwar.persistence.PacWarException;
//import com.mycompany.pacwar.persistence.PacWarPersistence;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.pacwar.services.PacWarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author karen
 */
@Service
public class PacWarServicesImpl implements PacWarServices {

    @Autowired
    Main main;

    @Autowired
    PacWarMessageController pwmc;
    
    @Override
    public ArrayList<PacMan> getPacMans(int room) {
        //System.out.println("getPacMans PacWarServicesImpl");
        return main.getRoom(room).getPacmans();
    }
    
    @Override
    public ArrayList<Room> getRooms() {
        return main.getRooms();
    }

    @Override
    public Room getRoom(int id) {
        return main.getRoom(id);
    }

    @Override
    public PacMan addPacMan(int roomId, PacMan pacMan) {
        //System.out.println("addPacMan PacWarServicesImpl");
        return main.getRoom(roomId).addPacMan(pacMan);
    }

    
    @Override
    public void addRoom(int id) {
        main.createRoom(id);
    }

    @Override
    public void movePacMan(String id, int key, int room) {
        //System.out.println("movePacMan PacWarServicesImpl");
        pwmc.sendMovementPacMan(main.movePacMan(id, key, room),room);
    }

    @Override
    public ArrayList<BackGroundItem> getBackGroundItemByRoomId(int idRoom) {
        return main.getBackGroundItems(idRoom);
    }

    @Override
    public void removeRoom(int roomId) {
        main.removeRoom(roomId);
    }

}