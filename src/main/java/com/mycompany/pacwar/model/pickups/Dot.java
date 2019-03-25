/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.pickups;

import javax.swing.ImageIcon;

public class Dot extends Pickable {

    public Dot(int posx, int posy) {
        super(posx, posy);
        ImageIcon ii = new ImageIcon("src/main/resources/static/img/pickups/dot.png");
        image = ii.getImage();
        points = 10;
        type = "Dot";
    }
}
