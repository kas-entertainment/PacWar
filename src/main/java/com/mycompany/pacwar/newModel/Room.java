package com.mycompany.pacwar.newModel;


import java.util.ArrayList;

public class Room {
    private int idRoom;
    private ArrayList<PacMan> pacmans = new ArrayList<>();
    public static int width = 42;
    public static int height = 23;
    private ArrayList<BackGroundItem> backGroundItems=new ArrayList<>();
    private Main main;

    public Room(){
        for(int i = 0; i<width;i++){
            for(int j = 0; j<height;j++){
                int num = (int) (Math.random()*15)+1;
                if(num==1){
                    Block b = new Block();
                    b.setPosX(i*BackGroundItem.getSize());
                    b.setPosY(j*BackGroundItem.getSize());
                    backGroundItems.add(b);
                }else if(num==2){
                    Heart h = new Heart();
                    h.setRoom(this);
                    h.setPosX(i*BackGroundItem.getSize());
                    h.setPosY(j*BackGroundItem.getSize());
                    backGroundItems.add(h);
                }else if(num==3){
                    Star s = new Star();
                    s.setRoom(this);
                    s.setPosX(i*BackGroundItem.getSize());
                    s.setPosY(j*BackGroundItem.getSize());
                    backGroundItems.add(s);
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
    
    public void removeHeart(Heart heart){
        main.eliminateHeart(heart, idRoom);
    }
    
    public void removeStar(Star star){
        main.eliminateStar(star, idRoom);
    }
    
    public void removeDot(Dot dot){
        main.eliminateDot(dot, idRoom);
    }
    
    public void removePacMan(PacMan pacman){
        if(pacman.isDead()){
            main.eliminatePacMan(pacman, idRoom);
        }
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
