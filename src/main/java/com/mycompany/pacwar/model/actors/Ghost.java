/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.actors;


import com.mycompany.pacwar.model.graphics.AnimationManager;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;

public class Ghost extends Movable {

    private boolean has_collided;
    private ArrayList<String> collides_with;
    private long start_dead_time;
    private int state, width, height, HvsV, accuracy_threshold;
    private String id, imageset, name;
    private AnimationManager anim_manager;
    public static final int CHASING = 1;
    public static final int SCARY = 2;
    public static final int DEAD = 3;

    public Ghost(int x, int y, int size, String id, String imageset, int HvsV, int accuracy_threshold) {
        super(x, y);
        state = CHASING;
        this.id = id;
        this.imageset = "blue";
        this.HvsV = HvsV;
        this.accuracy_threshold = accuracy_threshold;
        this.width = (int) (((long) size) * 0.95);
        this.height = (int) (((long) size) * 0.95);
        this.has_collided = false;
        this.collides_with = new ArrayList<String>();
        loadImageSet();
    }
    
    public Ghost(int x, int y, int size) {
        super(x, y);
        System.out.println("Entro a un constructor de Ghost clase Ghost");
        setSize(size);
        anim_manager = new AnimationManager();
        loadImageSet();

    }
    

    public String getID() {
        return id;
    }

    public void setHasCollided(boolean collided) {
        has_collided = collided;
    }

    public boolean isCollidingWithGhost(String id) {
        return (collides_with.indexOf(id) != -1);
    }

    public void removeGhostCollision(String id) {
        int ghost_index = collides_with.indexOf(id);
        if (ghost_index >= 0) {
            collides_with.remove(ghost_index);
        }
    }

    public void addGhostCollision(String id) {
        int ghost_index = collides_with.indexOf(id);
        if (ghost_index < 0) {
            collides_with.add(id);
        }
    }

    public int withManyGhostCollides() {
        return collides_with.size();
    }

    public int getState() {
        return state;
    }

    public void setState(int new_state) {
        state = new_state;
        if (new_state == DEAD) {
            start_dead_time = new Date().getTime();
        }
    }

    public void checkDeadTime() {
        long new_time = new Date().getTime();
        if (new_time >= start_dead_time + 5000) {
            state = CHASING;
            start_dead_time = 0;
        }
    }

    public boolean hasCollided() {
        return has_collided;
    }

    public void calculateNextDirection(int player_x, int player_y) {

        int rn;
        Random r = new Random();
        rn = r.nextInt(100);
        boolean search_vertical = (HvsV < rn);

        if (search_vertical) {
            if (player_y > GetY()) {
                setNextDirection(DOWN);
            } else {
                setNextDirection(UP);
            }
        } else {
            if (player_x > GetX()) {
                setNextDirection(RIGHT);
            } else {
                setNextDirection(LEFT);
            }
        }

        rn = r.nextInt(100);
        if (accuracy_threshold < rn) {
            
            int nextdir;
            do {
                nextdir = r.nextInt(4);
            } while (nextdir == getActualDirection());
            setNextDirection(nextdir);
        }

    }

    private void loadImageSet() {
        anim_manager = new AnimationManager();
        try {

            String[] anim = new String[2];            
            anim[0] = getImageSetFolder() + "up-1.png";
            anim[1] = getImageSetFolder() + "up-2.png";

            anim_manager.addAnimation("up", 200, 0, anim);

            anim[0] = getImageSetFolder() + "down-1.png";
            anim[1] = getImageSetFolder() + "down-2.png";

            anim_manager.addAnimation("down", 200, 0, anim);

            anim[0] = getImageSetFolder() + "left-1.png";
            anim[1] = getImageSetFolder() + "left-2.png";

            anim_manager.addAnimation("left", 200, 0, anim);

            anim[0] = getImageSetFolder() + "right-1.png";
            anim[1] = getImageSetFolder() + "right-2.png";

            anim_manager.addAnimation("right", 200, 0, anim);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    private String getImageSetFolder() {
        return "src/main/resources/static/img/actors/ghost/" + "blue" + "/";
    }
    
    /**
    private String getImageSetFolder(String other_imageset) {
        return "src/main/resources/static/img/actors/ghost/" + other_imageset + "/";
    }*/

    public Image getImage() {
        switch (state) {
            default:
            case CHASING:
                switch (getActualDirection()) {
                    case Movable.UP:
                        return anim_manager.getImage("up");
                    case Movable.DOWN:
                        return anim_manager.getImage("down");
                    case Movable.LEFT:
                        return anim_manager.getImage("left");
                    case Movable.RIGHT:
                    default:
                        return anim_manager.getImage("right");
                }

            case SCARY:
                return anim_manager.getImage("scary");
            case DEAD:
                return anim_manager.getImage("dead");
        }
    }

    public Rectangle getBounds() {
        Rectangle b = new Rectangle(GetX(), GetY(), width, height);
        return b;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setSize(int size) {
        width = (int) (((long) size) * 0.90);
        height = (int) (((long) size) * 0.90);
    }
}
