/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.pickups;

import javax.swing.ImageIcon;

public class SuperDot extends Pickable {

    public SuperDot(int x, int y) {
        super(x, y);
        ImageIcon ii = new ImageIcon("../resources/static/img/pickups/bigdot.png");
        image = ii.getImage();
        points = 10;
        type = "SuperDot";
    }
}
