/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.model.hud;

/**
 *
 * @author Sergio
 */
public class HUD {

    private String score;
    private String score_txt;
    private String start_txt;
    private String pause_txt;
    private String win_txt;
    private String game_over_txt;

    public HUD() {
        score_txt = "Puntuacion";
        score = "0";
        start_txt = "Bienvenido a PACWAR\nPulsa Intro para empezar";
        pause_txt = "Juego pausado\nPulsa P para continuar";
        win_txt = "Enhorabuena has ganado\n\nPulsa Intro para ir a\nla pantalla de inicio";
        game_over_txt = "Has perdido\n\nPulsa Intro para ir a\nla pantalla de inicio";
    }

    public void incrementScore(int value) {
        int new_value = Integer.parseInt(score) + value;
        score = String.valueOf(new_value);
    }

    public String getScore() {
        return score;
    }

    public void resetScore() {
        score = "0";
    }

    public String getScoreText() {
        return score_txt;
    }

    public String getStartText() {
        return start_txt;
    }

    public String getPauseText() {
        return pause_txt;
    }

    public String getWinText() {
        return win_txt;
    }

    public String getGameOverText() {
        return game_over_txt;
    }

}
