package com.mycompany.pacwar.newModel;

import java.util.ArrayList;

public class Room {
    private int idRoom;
    private ArrayList<PacMan> pacmans = new ArrayList<>();
    public static int size = 15;
    private ArrayList<BackGroundItem> backGroundItems=new ArrayList<>();
    private Main main;

    public Room(){
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){
                int num = (int) (Math.random()*10)+1;
                if(num==1){
                    Block b = new Block();
                    b.setPosX(i*BackGroundItem.getSize());
                    b.setPosY(j*BackGroundItem.getSize());
                    backGroundItems.add(b);
                }else{
                    Dot d = new Dot();
                    d.setRoom(this);
                    d.setPosX(i*BackGroundItem.getSize());
                    d.setPosY(j*BackGroundItem.getSize());
                    backGroundItems.add(d);
                }
            }
        }
    }

    public PacMan addPacMan(PacMan pacMan){
        pacMan.setRoom(this);
        pacmans.add(pacMan);
        return pacmans.get(pacmans.size()-1);
    }

    public PacMan movePacMan(String id, int key){
        PacMan pacMan = null;
        for(PacMan p:pacmans){
            if(p.getId().equals(id)){
                p.move(key);
                pacMan = p;
                break;
            }
        }
        return pacMan;
    }

    public void removeDot(Dot dot){
        main.eliminateDot(dot, idRoom);
    }

    public boolean canMove(PacMan pacMan, int key){
        boolean move = true;
        for(BackGroundItem bgi:backGroundItems){
            move = move && bgi.doesMove(pacMan,key);
            if(!move) break;
        }
        return move;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public ArrayList<PacMan> getPacmans() {
        return pacmans;
    }

    public void setPacmans(ArrayList<PacMan> pacmans) {
        this.pacmans = pacmans;
    }

    public ArrayList<BackGroundItem> getBackGroundItems() {
        return backGroundItems;
    }

    public void setBackGroundItems(ArrayList<BackGroundItem> backGroundItems) {
        this.backGroundItems = backGroundItems;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}