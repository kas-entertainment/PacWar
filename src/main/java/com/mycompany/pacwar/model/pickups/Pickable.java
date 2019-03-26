/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.pickups;

import java.awt.Image;
import java.awt.Rectangle;

public class Pickable {

    private int x;
    private int y;
    private int width;
    private int height;
    protected Image image;
    protected int points;
    protected String type;

    public Pickable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSize(int size) {
        width = (int) (((long) size) * 0.90);
        height = (int) (((long) size) * 0.90);
    }

    public Rectangle getBounds() {
        Rectangle b = new Rectangle(x, y, width, height);
        return b;
    }

}
