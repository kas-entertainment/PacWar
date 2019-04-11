/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pacwar.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Karen Mora
 */
@Component
@Qualifier("GamePostgresRepository")
public class GamePostgresRepository {
    @Value("${spring.datasource.url}")
    private String urlBd;
    @Value("${spring.datasource.username}")
    private String userNameBd;
    @Value("${spring.datasource.password}")
    private String passwordBd;

    
}
