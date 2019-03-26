/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.logic;

public class GhostConfig {

    String id;
    String name;
    String imageset;
    int speed;
    int accuracy_threshold;
    int HvsV;

    public GhostConfig(String id, String name, String imageset, int speed, int accuracy_threshold, int HvsV) {
        this.id = id;
        this.name = name;
        this.imageset = imageset;
        this.speed = speed;
        this.accuracy_threshold = accuracy_threshold;
        this.HvsV = HvsV;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageSet() {
        return imageset;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAccuracyThreshold() {
        return accuracy_threshold;
    }

    public int getHvsV() {
        return HvsV;
    }

}
