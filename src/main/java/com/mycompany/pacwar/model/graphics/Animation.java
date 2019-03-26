/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.graphics;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class Animation {

    private String name;
    private int duration;
    private int loops;
    private int actual_loop;
    private int image_number;
    private int image_interval;
    private long animation_start_time;
    private ArrayList<Image> anim_images;

    public Animation(String anim_name, int anim_duration, int anim_loop, String[] images_path) throws FileNotFoundException {

        name = anim_name;
        duration = anim_duration;
        loops = anim_loop;
        actual_loop = 0;

        anim_images = new ArrayList<Image>();
        for (String i : images_path) {
            ImageIcon ii = new ImageIcon(i);
            anim_images.add(ii.getImage());
        }

        image_number = images_path.length;
        image_interval = duration / image_number;

        animation_start_time = 0;
    }

    public Image getImage() {

        if (animation_start_time == 0) {
            restartAnimation();
        }

        return anim_images.get(getFrameNumber());

    }

    public void restartAnimation() {
        animation_start_time = new Date().getTime();
    }

    public void resetAnimation() {
        animation_start_time = 0;
        actual_loop = 0;
    }

    private int getFrameNumber() {

        long actual_milis = new Date().getTime();
        int interval = (int) (actual_milis - animation_start_time);
        
        if ((interval >= duration) && (loops != 0) && (actual_loop >= loops)) {
            return image_number - 1;
        }

        if (interval >= duration) {

            restartAnimation();

            if (loops != 0) {
                actual_loop++;

                
                if (actual_loop >= loops) {
                    return image_number - 1;
                }
            }

            actual_milis = new Date().getTime();
            interval = (int) (actual_milis - animation_start_time);
        }
	
        if (interval == 0) {
            return 0;
        }
        int frame_number = ((int) interval) / image_interval;
        return frame_number;

    }

    public String getAnimationName() {
        return name;
    }

}
