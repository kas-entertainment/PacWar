/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.actors;

import com.mycompany.pacwar.model.graphics.AnimationManager;
import com.mycompany.pacwar.model.actors.Movable;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Pacman extends Movable {

    private int width, height;
    private AnimationManager anim_manager;

    public Pacman(int x, int y, int size) {
        super(x, y);

        setSize(size);

        anim_manager = new AnimationManager();

        setPlayerImages();

    }

    private void setPlayerImages() {

        try {

            String[] anim = new String[2];
            anim[0] = "src/main/resources/static/img/actors/pacman/up-1.png";
            anim[1] = "src/main/resources/static/img/actors/pacman/up-2.png";

            anim_manager.addAnimation("up", 200, 0, anim);

            anim[0] = "src/main/resources/static/img/actors/pacman/down-1.png";
            anim[1] = "src/main/resources/static/img/actors/pacman/down-2.png";

            anim_manager.addAnimation("down", 200, 0, anim);

            anim[0] = "src/main/resources/static/img/actors/pacman/left-1.png";
            anim[1] = "src/main/resources/static/img/actors/pacman/left-2.png";

            anim_manager.addAnimation("left", 200, 0, anim);

            anim[0] = "src/main/resources/static/img/actors/pacman/right-1.png";
            anim[1] = "src/main/resources/static/img/actors/pacman/right-2.png";

            anim_manager.addAnimation("right", 200, 0, anim);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public Image getImage() {
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

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                setNextDirection(LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                setNextDirection(RIGHT);
                break;
            case KeyEvent.VK_UP:
                setNextDirection(UP);
                break;
            case KeyEvent.VK_DOWN:
                setNextDirection(DOWN);
                break;
        }

    }

    public Rectangle getBounds() {
        Rectangle b = new Rectangle(GetX(), GetY(), width, height);
        return b;
    }

    public void setSize(int size) {
        width = (int) (((long) size) * 0.90);
        height = (int) (((long) size) * 0.90);
    }

}
