/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {

    private int level_box_size;
    private long invincible_mode_duration;

    HashMap<String, GhostConfig> ghosts_c;

    private static Config instance = null;

    protected Config() {

        ghosts_c = new HashMap<String, GhostConfig>();
        JSONObject obj = getConfigFile();

        Long size = (Long) obj.get("level_box_size");
        level_box_size = size.intValue();
        invincible_mode_duration = (Long) obj.get("invincible_mode_duration");

        JSONArray ghosts = (JSONArray) obj.get("ghosts");

        Iterator<JSONObject> iterator = ghosts.iterator();
        while (iterator.hasNext()) {
            JSONObject g = iterator.next();
            String id = (String) g.get("id");
            String name = (String) g.get("name");
            String imageset = (String) g.get("imageset");
            Long HvsV = (Long) g.get("HvsV");
            Long speed = (Long) g.get("speed");
            Long accuracy = (Long) g.get("accuracy_threshold");
            GhostConfig ghost_c = new GhostConfig(id, name, imageset, speed.intValue(), accuracy.intValue(), HvsV.intValue());
            ghosts_c.put(id, ghost_c);
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getLevelBoxSize() {
        return level_box_size;
    }

    public long getInvincibleModeDuration() {
        return invincible_mode_duration;
    }

    public GhostConfig getGhostConfig(String id) {
        return ghosts_c.get(id);
    }

    private JSONObject getConfigFile() {
        try {
            String path = new File(".").getCanonicalPath();
            String file_path = path + "/src/main/resources/static/config/config.json";

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(file_path));
            JSONObject ret_value = (JSONObject) obj;

            return ret_value;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }
}
