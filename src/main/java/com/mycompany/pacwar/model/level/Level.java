/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.level;

/**
 *
 * @author Sergio
 */
import com.mycompany.pacwar.model.logic.*;
import com.mycompany.pacwar.model.pickups.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Level {

    private String level_image_pattern;
    private int[][] cells;
    private int rowcount;
    private int colcount;
    private String[] ghosts_in_level;
    private HashMap<String, Image> images;
    private ArrayList<Pickable> pickables;
    private int[] player_initial_position;
    private int[] red_ghost_initial_position;
    private int[] blue_ghost_initial_position;
    private int[] orange_ghost_initial_position;
    private int[] pink_ghost_initial_position;
    private Config config;

    public Level() {
        images = new HashMap<String, Image>();
        pickables = new ArrayList<Pickable>();
        player_initial_position = new int[2];
        player_initial_position[0] = 0;
        player_initial_position[1] = 0;

        config = Config.getInstance();

    }

    public void setLevelImagePatternName(String pattern) {
        level_image_pattern = pattern;
    }

    public String getLevelImagePatternName() {
        return level_image_pattern;
    }

    public void createCellBoard(int rows, int cols) {
        rowcount = rows;
        colcount = cols;
        cells = new int[rows][cols];
    }

    public int getRowCount() {
        return rowcount;
    }

    public int getColCount() {
        return colcount;
    }

    public ArrayList<Pickable> getPickables() {
        return pickables;
    }

    public void setCell(int row, int col, int value) {
        cells[row][col] = value;

        int[] px_position;
        switch (value) {
            case 1:
                px_position = convertRowcolsToPixels(row, col);
                Dot dot = new Dot(px_position[0], px_position[1]);
                dot.setSize(config.getLevelBoxSize());
                dot.setPoints(10);
                pickables.add(dot);
                break;
            case 2:
                px_position = convertRowcolsToPixels(row, col);
                SuperDot s_dot = new SuperDot(px_position[0], px_position[1]);
                s_dot.setSize(config.getLevelBoxSize());
                s_dot.setPoints(20);
                pickables.add(s_dot);
                break;
            case 3:
                player_initial_position = convertRowcolsToPixels(row, col);
                break;
            case 4:
                red_ghost_initial_position = convertRowcolsToPixels(row, col);
                break;
            case 5:
                orange_ghost_initial_position = convertRowcolsToPixels(row, col);
                break;
            case 6:
                blue_ghost_initial_position = convertRowcolsToPixels(row, col);
                break;
            case 7:
                pink_ghost_initial_position = convertRowcolsToPixels(row, col);
                break;
        }
    }

    public int getCell(int row, int col) {
        return cells[row][col];
    }

    public int[] getPlayerInitialPosition() {
        return player_initial_position;
    }

    public Image getCellImage(int row, int col) {
        if (images == null) {
            createImageSet();
        }
        if (cells[row][col] < 0) {
            if (!images.containsKey("not_navigable" + cells[row][col])) {
                createImage("not_navigable" + cells[row][col], cells[row][col]);
            }
            return images.get("not_navigable" + cells[row][col]);
        } else {
            return images.get("navigable");
        }
    }

    private void createImage(String image_name, int filename) {
        String resource = filename + ".png";
        ImageIcon ii = new ImageIcon("src/main/resources/static/img/tilesets/default/" + resource);
        images.put(image_name, ii.getImage());
    }

    public void createImageSet() {
        Image ii = new ImageIcon("src/main/resources/static/img/tilesets/default/0.png").getImage();
        images.put("navigable", ii);

    }

    public int[] convertRowcolsToPixels(int row, int col) {
        int[] px_position = new int[2];
        px_position[0] = col * config.getLevelBoxSize();
        px_position[1] = row * config.getLevelBoxSize();
        return px_position;
    }

    public int[] convertRowcolsToPixelsCentered(int row, int col) {
        int[] px_position = convertRowcolsToPixels(row, col);
        px_position[0] = px_position[0] + (config.getLevelBoxSize() / 2);
        px_position[1] = px_position[1] + (config.getLevelBoxSize() / 2);
        return px_position;
    }

    public int[] convertPixelsInRowCol(int x, int y) {
        int[] row_col = new int[2];
        row_col[0] = y / config.getLevelBoxSize();
        row_col[1] = x / config.getLevelBoxSize();
        return row_col;
    }

    public int[] getUpperRowCol(int row, int col) {
        int[] row_col = new int[2];
        row_col[0] = row - 1;
        row_col[1] = col;
        return row_col;
    }

    public int[] getBottomRowCol(int row, int col) {
        int[] row_col = new int[2];
        row_col[0] = row + 1;
        row_col[1] = col;
        return row_col;
    }

    public int[] getLeftRowCol(int row, int col) {
        int[] row_col = new int[2];
        row_col[0] = row;
        row_col[1] = col - 1;
        return row_col;
    }

    public int[] getRightRowCol(int row, int col) {
        int[] row_col = new int[2];
        row_col[0] = row;
        row_col[1] = col + 1;
        return row_col;
    }

    public boolean isCellNavigable(int row, int col) {
        return (cells[row][col] >= 0);
    }

    public void setGhosts(String[] ghosts) {
        ghosts_in_level = ghosts;
    }

    public String[] getGhostsInLevel() {
        return ghosts_in_level;
    }

    public int[] getGhostInitialPosition(String id) {
        int[] retval = new int[2];
        retval[0] = 0;
        retval[1] = 0;

        if (id.equals("red")) {
            retval = red_ghost_initial_position;
        }

        if (id.equals("blue")) {
            retval = blue_ghost_initial_position;
        }

        if (id.equals("orange")) {
            retval = orange_ghost_initial_position;
        }

        if (id.equals("pink")) {
            retval = pink_ghost_initial_position;
        }

        return retval;

    }
}
