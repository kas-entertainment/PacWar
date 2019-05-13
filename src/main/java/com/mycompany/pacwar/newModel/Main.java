package com.mycompany.pacwar.newModel;

import java.util.ArrayList;

public interface Main {

    ArrayList<Room> getRooms();

    Room getRoom(int id);

    void createRoom(int id);

    PacMan movePacMan(String id, int key, int idRoom);

    ArrayList<BackGroundItem> getBackGroundItems(int idRoom);

    void eliminateDot(Dot dot, int idRoom);
    
    void eliminateHeart(Heart heart, int idRoom);
    
    void eliminateStar(Star star, int idRoom);
}
