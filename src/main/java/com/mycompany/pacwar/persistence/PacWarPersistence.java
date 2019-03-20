/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import com.mycompany.pacwar.game.BattleException;
import com.mycompany.pacwar.model.Pacman;
import com.mycompany.pacwar.model.Player;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andres
 */
public interface PacWarPersistence {
    public void addPlayer(String name,String lastname,String mail,String nick,String password) throws PacWarException;
    public List<Player> getPlayers();
}
