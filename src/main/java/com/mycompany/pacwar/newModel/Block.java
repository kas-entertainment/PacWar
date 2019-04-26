package com.mycompany.pacwar.newModel;

public class Block extends Element implements BackGroundItem{

    public int size = BackGroundItem.getSize();

    private String type = "Block";

    private String id = type + (int) Math.random() *10000;

    @Override
    public boolean doesMove(PacMan pacMan, int key) {
        boolean move = true;
        if(key == 37 ){//LEFT
            if(colision(pacMan.posX-PacMan.velocity,pacMan.posY,pacMan.posX+PacMan.size-PacMan.velocity,pacMan.posY+PacMan.size,posX,posY,posX+size,posY+size)) move = false;
        }else if(key == 38){//UP
            if(colision(pacMan.posX,pacMan.posY-PacMan.velocity,pacMan.posX+PacMan.size,pacMan.posY+PacMan.size-PacMan.velocity,posX,posY,posX+size,posY+size) ) move = false;
        }else if(key ==39){//RIGHT
            if(colision(pacMan.posX+PacMan.velocity,pacMan.posY,pacMan.posX+PacMan.size+PacMan.velocity,pacMan.posY+PacMan.size,posX,posY,posX+size,posY+size) ) move = false;
        }else{//DOWN
            if( colision(pacMan.posX,pacMan.posY+PacMan.velocity,pacMan.posX+PacMan.size,pacMan.posY+PacMan.size+PacMan.velocity,posX,posY,posX+size,posY+size)) move = false;
        }
        return move;
    }

    public static boolean colision(int x1, int y1, int x2, int y2,int xp1, int yp1, int xp2, int yp2){
        boolean col = false;
        if(pointInPositions(x1,y1,xp1,yp1,xp2,yp2)) col = true;
        if(pointInPositions(x2,y2,xp1,yp1,xp2,yp2)) col = true;
        if(pointInPositions(x2,y1,xp1,yp1,xp2,yp2)) col = true;
        if(pointInPositions(x1,y2,xp1,yp1,xp2,yp2)) col = true;

        return col;
    }

    public static boolean pointInPositions(int x, int y, int xp1, int yp1, int xp2, int yp2){
        return x>=xp1 && x<=xp2 && y>=yp1 && y<=yp2;
    }

    @Override
    public String getType() {
        return "Block";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean getVisible() {
        return true;
    }
}
