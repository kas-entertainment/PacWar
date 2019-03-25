/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.graphics;

/**
 *
 * @author Sergio
 */
import com.mycompany.pacwar.model.graphics.Animation;
import java.util.HashMap;
import java.awt.Image;
import java.io.FileNotFoundException;

/**
 * Clase AnimationManager:
 *
 * Esta clase tiene el propósito de gestionar animaciones de los personajes del
 * juego.
 *
 * TODO: - Establecer un sistema de pausa de animación.
 *
 * @author Daniel González Zaballos <dgzaballos@gmail.com>
 *
 */
public class AnimationManager {

    private String current_animation;
    private HashMap<String, Animation> animations;

    public AnimationManager() {
        animations = new HashMap<String, Animation>();
    }

    public void addAnimation(String name, int duration, int loop, String[] files) throws FileNotFoundException {
        Animation anim = new Animation(name, duration, loop, files);
        animations.put(name, anim);
    }

    public Image getImage(String animation) {
        current_animation = animation;
        return animations.get(animation).getImage();
    }

    public String getCurrentAnimation() {
        return current_animation;
    }

}
