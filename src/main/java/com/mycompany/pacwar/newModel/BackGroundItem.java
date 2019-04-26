package com.mycompany.pacwar.newModel;

public interface BackGroundItem {
    boolean doesMove(PacMan pacMan, int key);
    static int getSize(){
        return 40;
    }
    String getType();
    String getId();
    boolean getVisible();
}
