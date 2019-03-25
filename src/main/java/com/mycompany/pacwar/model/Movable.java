/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model;

/**
 *
 * @author KAS
 */
public class Movable {

    private int x;
    private int y;
    private int dx; 
    private int dy;
    private boolean moving;
    private double velocity;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;
    private int actual_direction;
    private int next_direction;

    public Movable(int new_x, int new_y) {
        x = new_x;
        y = new_y;
        dy = 1;
        dx = 1;
        moving = false;
        velocity = 1.0;
        actual_direction = 0;
        next_direction = 0;
    }

    public void setDirection(int direction) {
        actual_direction = direction;
    }

    public void move() {
        switch (actual_direction) {
            case UP:
                MoveUp();
                break;
            case DOWN:
                MoveDown();
                break;
            case RIGHT:
                MoveRight();
                break;
            case LEFT:
                MoveLeft();
                break;
            default:
                break;
        }
    }
    
    public int[] GetPosition() {

        int[] ret_val = new int[2];

        ret_val[0] = this.x;
        ret_val[1] = this.y;

        return ret_val;
    }

    public void MoveUp() {
        this.y = this.y - this.dy;
    }

    public void MoveDown() {
        this.y = this.y + this.dy;
    }

    public void MoveRight() {
        this.x = this.x + this.dx;
    }

    public void MoveLeft() {
        this.x = this.x - this.dx;
    }

    public boolean IsMoving() {
        return this.moving;
    }

    public void SetVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double GetVelocity() {
        return this.velocity;
    }

    public int GetX() {
        return this.x;
    }

    public void SetX(int x) {
        this.x = x;
    }

    public int GetY() {
        return this.y;
    }

    public void SetY(int y) {
        this.y = y;
    }

    public int GetDeltaX() {
        return this.dx;
    }

    public void SetDeltaX(int dx) {
        this.dx = dx;
    }

    public int GetDeltaY() {
        return this.dy;
    }

    public void SetDeltaY(int dy) {
        this.dy = dy;
    }

    public void stop() {
        actual_direction = 0;
        next_direction = 0;
        moving = false;
    }

    public int getActualDirection() {
        return actual_direction;
    }

    public int getNextDirection() {
        return next_direction;
    }

    public void setNextDirection(int direction) {
        if (actual_direction == 0) {
            actual_direction = direction;
            next_direction = 0;
        } else {
            next_direction = direction;
        }

    }

    public boolean isNextDirectionOppositeToActual() {
        return (actual_direction == UP && next_direction == DOWN)
                || (actual_direction == DOWN && next_direction == UP)
                || (actual_direction == RIGHT && next_direction == LEFT)
                || (actual_direction == LEFT && next_direction == RIGHT);
    }

    public void changeToNextDirection() {
        actual_direction = next_direction;
        next_direction = 0;
    }

    public void setOppositeDirection() {
        switch (actual_direction) {
            case UP:
                actual_direction = DOWN;
                break;
            case DOWN:
                actual_direction = UP;
                break;
            case LEFT:
                actual_direction = RIGHT;
                break;
            case RIGHT:
                actual_direction = LEFT;
                break;
        }
    }

    public int getOppositeDirection() {
        switch (actual_direction) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
        }
        return 0;
    }

}
