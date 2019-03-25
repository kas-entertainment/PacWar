/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

import com.mycompany.pacwar.model.level.Board;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {

    /**
     * Constructor. Inicializa los atributos correspondientes a JFrame y aniade
     * un objeto Board (hijo de JPanel).
     *
     */
    public Main() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(570, 676);
        setLocationRelativeTo(null);

        setTitle("Pacman");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();

    }
}
