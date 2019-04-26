package com.mycompany.pacwar.newModel;

public class PacMan extends Element{
    enum Dirrections{
        U,
        D,
        L,
        R
    }

    private String id;

    private char dirrection;

    public static int size = 10;

    public static int velocity = 10;

    private Room room;

    private int points;

    public void addPoints(){
        points++;
    }

    public void move(int key){
        if(room.canMove(this,key)) {
            if (key == 37) {
                if (posX > 0) posX -= velocity;
                dirrection = 'L';
            } else if (key == 38) {
                if (posY > 0) posY -= velocity;
                dirrection = 'U';
            } else if (key == 39) {
                if (posX < ((Room.size) * BackGroundItem.getSize())) posX += velocity;
                dirrection = 'R';
            } else {
                if (posY < ((Room.size) * BackGroundItem.getSize())) posY += velocity;
                dirrection = 'D';
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getDirrection() {
        return dirrection;
    }

    public void setDirrection(char dirrection) {
        this.dirrection = dirrection;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        PacMan.size = size;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
