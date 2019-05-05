package com.mycompany.pacwar.services;

import com.mycompany.pacwar.model.Jugador;
import com.mycompany.pacwar.newModel.BackGroundItem;
import com.mycompany.pacwar.newModel.GHost;
import com.mycompany.pacwar.newModel.PacMan;
import com.mycompany.pacwar.newModel.Room;

import java.util.ArrayList;
import java.util.List;

public interface PacWarServices {

    void addPlayer(String name, String lastName, String email, String nikName, String password);

    Jugador getJugadorByName(String nikName);

    List<Jugador> getAllGamers();

    List<Jugador> getGamersSameSesion(String idSala);

    void logIn(String nickname, String password);

    ArrayList<PacMan> getPacMans(int room);
    
    ArrayList<GHost> getGhosts(int room,String name);
    
    ArrayList<Room> getRooms();

    Room getRoom(int id);

    PacMan addPacMan(int roomId, PacMan pacMan);

    void addRoom(int id);

    void movePacMan(String id, int key, int room);

    ArrayList<BackGroundItem> getBackGroundItemByRoomId(int idRoom);

    public void moveGhost(String id, int key, int room);

    public GHost addGhost(int roomId, GHost ghost, String name);
}
