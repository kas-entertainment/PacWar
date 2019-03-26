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
import com.mycompany.pacwar.model.actors.Movable;
import com.mycompany.pacwar.model.actors.Ghost;
import com.mycompany.pacwar.model.actors.Pacman;
import com.mycompany.pacwar.model.hud.HUD;
import com.mycompany.pacwar.model.logic.Config;
import com.mycompany.pacwar.model.logic.GhostConfig;
import com.mycompany.pacwar.model.pickups.Pickable;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

    private Config gameconfig;
    private Timer timer;
    private Level level;
    private Pacman player;
    private HUD hud;
    private ArrayList<Ghost> ghosts;
    private Font text_font;
    private int game_screen;
    public static final int START_SCREEN = 0;
    public static final int WIN_SCREEN = 1;
    public static final int PAUSE_SCREEN = 2;
    public static final int GAME_OVER_SCREEN = 3;
    public static final int PLAY_SCREEN = 4;
    private boolean invincible_mode;
    private long start_invincible_mode;

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        setTextFont();
        gameconfig = Config.getInstance();
        game_screen = START_SCREEN;

        hud = new HUD();

        timer = new Timer(5, this);
        timer.start();

    }

    private void configureGame() {
        invincible_mode = false;
        start_invincible_mode = 0;

        level = new LevelLoader().LoadLevel(1);

        loadGhosts();

        int[] player_pos = level.getPlayerInitialPosition();

        player = new Pacman(player_pos[0], player_pos[1], gameconfig.getLevelBoxSize());

        hud.resetScore();

    }

    private void loadGhosts() {

        ghosts = new ArrayList<Ghost>();
        String[] ghosts_in_level = level.getGhostsInLevel();
        for (String s : ghosts_in_level) {
            GhostConfig gc = gameconfig.getGhostConfig(s);
            int[] pos = level.getGhostInitialPosition(gc.getId());

            Ghost g = new Ghost(pos[0], pos[1], gameconfig.getLevelBoxSize(), gc.getId(), gc.getImageSet(), gc.getHvsV(), gc.getAccuracyThreshold());
            ghosts.add(g);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (game_screen == PLAY_SCREEN) {
            checkInvincibleMode();

            checkPickables();
            checkPlayerGhosts();

            moveGhosts();

            movePlayer();

        }

        repaint();
    }

    private void calculateGhostNextDirectionInCollision(Ghost g1, Ghost g2) {

        if (g1.getActualDirection() == g2.getActualDirection()) {
            if (g1.getActualDirection() == Movable.LEFT) {
                if (g1.GetX() < g2.GetX()) {
                    g2.setOppositeDirection();
                } else {
                    g1.setOppositeDirection();
                }
                return;
            }
            if (g1.getActualDirection() == Movable.RIGHT) {
                if (g1.GetX() > g2.GetX()) {
                    g2.setOppositeDirection();
                } else {
                    g1.setOppositeDirection();
                }
            }
            if (g1.getActualDirection() == Movable.UP) {
                if (g1.GetY() < g2.GetY()) {
                    g2.setOppositeDirection();
                } else {
                    g1.setOppositeDirection();
                }
            }

            if (g1.getActualDirection() == Movable.DOWN) {
                if (g1.GetX() > g2.GetX()) {
                    g2.setOppositeDirection();
                } else {
                    g1.setOppositeDirection();
                }
            }
        } else {
            if (g1.getActualDirection() == Movable.LEFT) {
                if (g1.GetX() > g2.GetX()) {
                    g1.setOppositeDirection();
                    g2.setOppositeDirection();
                }
            }

            if (g1.getActualDirection() == Movable.RIGHT) {
                if (g1.GetX() < g2.GetX()) {
                    g1.setOppositeDirection();
                }
            }
            if (g1.getActualDirection() == Movable.UP) {
                if (g1.GetY() > g2.GetY()) {
                    g1.setOppositeDirection();
                }
            }

            if (g1.getActualDirection() == Movable.DOWN) {
                if (g1.GetX() < g2.GetX()) {
                    g1.setOppositeDirection();
                }
            }
        }
    }

    private void checkGhostCollisions(Ghost ghost) {
        boolean collided = false;
        for (Ghost g : ghosts) {
            if (ghost.getID().equals(g.getID())) {
                continue;
            } else {

                Rectangle g1 = ghost.getBounds();
                Rectangle g2 = g.getBounds();

                if (g1.intersects(g2)) {

                    if (ghost.isCollidingWithGhost(g.getID())) {
                        continue;
                    }

                    collided = true;
                    ghost.addGhostCollision(g.getID());
                    g.addGhostCollision(ghost.getID());

                    if (!ghost.hasCollided()) {
                        ghost.setHasCollided(true);
                    }

                    if (!g.hasCollided()) {
                        g.setHasCollided(true);
                    }

                    calculateGhostNextDirectionInCollision(ghost, g);

                } else {

                    ghost.removeGhostCollision(g.getID());
                    g.removeGhostCollision(ghost.getID());
                }
            }
        }

        if (!collided) {
            ghost.setHasCollided(false);
        }
    }

    private void checkPlayerGhosts() {

        Rectangle player_b = player.getBounds();
        Iterator<Ghost> iterator = ghosts.iterator();
        while (iterator.hasNext()) {
            Ghost g = iterator.next();
            Rectangle g_b = g.getBounds();
            if (player_b.intersects(g_b)) {

                if (g.getState() == Ghost.DEAD) {
                    continue;
                }

                if (invincible_mode) {
                    hud.incrementScore(100);
                    g.setState(Ghost.DEAD);

                    int[] g_position = level.getGhostInitialPosition(g.getID());
                    g.SetX(g_position[0]);
                    g.SetY(g_position[1]);

                } else {
                    loadGameOverScreen();
                }
            }
        }
    }

    private void moveGhosts() {

        Iterator<Ghost> iterator = ghosts.iterator();

        while (iterator.hasNext()) {

            Ghost g = iterator.next();

            if (g.getState() == Ghost.DEAD) {
                g.checkDeadTime();
                continue;
            }

            checkGhostCollisions(g);

            if (g.withManyGhostCollides() > 1) {
                continue;
            }

            if (g.getActualDirection() == 0 || g.getNextDirection() == 0) {
                g.calculateNextDirection(player.GetX(), player.GetY());
            }

            if (canMove(g)) {
                if (!g.hasCollided()) {
                    if (hasToChangeToNextDirection(g)) {
                        g.changeToNextDirection();
                        g.calculateNextDirection(player.GetX(), player.GetY());
                    }
                }
                g.move();
            } else {
                g.calculateNextDirection(player.GetX(), player.GetY());
            }
        }
    }

    private void movePlayer() {
        boolean can_move;

        if (hasToChangeToNextDirection(player)) {
            player.changeToNextDirection();
        }
        can_move = canMove(player);
        if (can_move) {
            player.move();
        }
    }

    private void checkPickables() {
        Rectangle player_b = player.getBounds();
        ArrayList<Pickable> picks = level.getPickables();
        Iterator<Pickable> iterator = picks.iterator();

        while (iterator.hasNext()) {
            Pickable pick = (Pickable) iterator.next();
            Rectangle pick_b = pick.getBounds();

            if (player_b.intersects(pick_b)) {

                hud.incrementScore(pick.getPoints());

                if (pick.getType().equals("SuperDot")) {
                    setInvincibleMode();
                }

                iterator.remove();
            }
        }

        if (level.getPickables().isEmpty()) {
            loadWinScreen();
        }
    }

    private boolean hasToChangeToNextDirection(Movable actor) {
        int next_direction = actor.getNextDirection();
        int[] actor_position = actor.GetPosition();

        if (actorIsCentered(actor_position)) {

            if (nextCellIsNavigable(actor_position, next_direction)) {
                return true;
            }
        }

        if (actor instanceof Pacman) {
            if (actor.isNextDirectionOppositeToActual()) {
                if (nextCellIsNavigable(actor_position, next_direction)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canMove(Movable actor) {
        if (actor instanceof Ghost) {

        }
        int actual_direction = actor.getActualDirection();
        int[] actor_position = actor.GetPosition();

        if (hasToChangeToNextDirection(actor)) {
            return true;
        }

        if (nextCellIsNavigable(actor_position, actual_direction) || (!actorIsCentered(actor_position))) {
            return true;
        }

        return false;
    }

    private void setInvincibleMode() {
        start_invincible_mode = new Date().getTime();
        invincible_mode = true;
        Iterator<Ghost> iterator = ghosts.iterator();

        while (iterator.hasNext()) {
            Ghost g = iterator.next();
            if (g.getState() != Ghost.DEAD) {
                g.setState(Ghost.SCARY);
            }
        }
    }

    private void checkInvincibleMode() {
        long actual_milis = new Date().getTime();
        if (actual_milis >= (start_invincible_mode + gameconfig.getInvincibleModeDuration())) {
            unsetInvincibleMode();
        }
    }

    private void unsetInvincibleMode() {
        invincible_mode = false;
        Iterator<Ghost> iterator = ghosts.iterator();

        while (iterator.hasNext()) {
            Ghost g = iterator.next();
            if (g.getState() != Ghost.DEAD) {
                g.setState(Ghost.CHASING);
            }
        }
    }

    private boolean actorIsCentered(int[] position_x_y) {
        int[] row_col = level.convertPixelsInRowCol(position_x_y[0], position_x_y[1]);
        int[] row_col_x_y = level.convertRowcolsToPixels(row_col[0], row_col[1]);
        return ((position_x_y[0] == row_col_x_y[0]) && (position_x_y[1] == row_col_x_y[1]));
    }

    private boolean nextCellIsNavigable(int[] actor_position, int next_direction) {
        int centered_x = actor_position[0];
        int centered_y = actor_position[1];
        int[] row_col = level.convertPixelsInRowCol(centered_x, centered_y);

        int[] next_cell = new int[2];
        next_cell[0] = 0;
        next_cell[1] = 0;

        switch (next_direction) {
            case Movable.UP:
                next_cell = level.getUpperRowCol(row_col[0], row_col[1]);
                break;
            case Movable.DOWN:
                next_cell = level.getBottomRowCol(row_col[0], row_col[1]);
                break;
            case Movable.LEFT:
                next_cell = level.getLeftRowCol(row_col[0], row_col[1]);
                break;
            case Movable.RIGHT:
                next_cell = level.getRightRowCol(row_col[0], row_col[1]);
                break;
        }

        return level.isCellNavigable(next_cell[0], next_cell[1]);

    }

    private void loadGame() {
        configureGame();
        game_screen = PLAY_SCREEN;

    }

    private void loadWinScreen() {
        game_screen = WIN_SCREEN;
    }

    private void loadGameOverScreen() {
        game_screen = GAME_OVER_SCREEN;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setFont(text_font.deriveFont((float) ((float) gameconfig.getLevelBoxSize() * 0.70)));
        switch (game_screen) {
            case PAUSE_SCREEN:
                paintPauseScreen(g2d);
                break;
            case START_SCREEN:
                paintStartScreen(g2d);
                break;
            case WIN_SCREEN:
                paintWinScreen(g2d);
                break;
            case GAME_OVER_SCREEN:
                paintGameOverScreen(g2d);
                break;
            case PLAY_SCREEN:
            default:

                paintBackground(g2d);

                paintPickables(g2d);

                g2d.drawImage(player.getImage(), player.GetX(), player.GetY(), gameconfig.getLevelBoxSize(), gameconfig.getLevelBoxSize(), this);

                paintGhosts(g2d);

                paintInGameHUD(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }

    private void paintGhosts(Graphics2D g2d) {
        Iterator<Ghost> iterator = ghosts.iterator();
        while (iterator.hasNext()) {
            Ghost g = iterator.next();
            g2d.drawImage(g.getImage(), g.GetX(), g.GetY(), gameconfig.getLevelBoxSize(), gameconfig.getLevelBoxSize(), this);
        }
    }

    private void paintBackground(Graphics2D g2d) {

        int rows = level.getRowCount();
        int cols = level.getColCount();
        int r, c, bg_x, bg_y = 0;

        for (r = 0; r < rows; r++) {
            bg_x = 0;
            for (c = 0; c < cols; c++) {
                Image bg_image = level.getCellImage(r, c);
                g2d.drawImage(bg_image, bg_x, bg_y, gameconfig.getLevelBoxSize(), gameconfig.getLevelBoxSize(), this);
                bg_x = bg_x + gameconfig.getLevelBoxSize();
            }
            bg_y = bg_y + gameconfig.getLevelBoxSize();
        }
    }

    private void paintPickables(Graphics2D g2d) {
        ArrayList<Pickable> picks = level.getPickables();
        Iterator<Pickable> iterator = picks.iterator();

        while (iterator.hasNext()) {
            Pickable pick = (Pickable) iterator.next();
            Image img = pick.getImage();

            int x = pick.getX();
            int y = pick.getY();

            g2d.drawImage(img, x, y, gameconfig.getLevelBoxSize(),
                    gameconfig.getLevelBoxSize(), this);
        }
    }

    private void paintInGameHUD(Graphics2D g2d) {
        Color color = (Color.WHITE);
        g2d.setColor(color);
        drawString(g2d, hud.getScoreText(), 20, 2);
        drawString(g2d, hud.getScore(), 160, 2);
    }

    private void paintPauseScreen(Graphics2D g2d) {
        Rectangle rect = getBounds();
        Color color = Color.BLACK;
        g2d.setColor(color);
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2d.fillRect(rect.x, rect.y, rect.width, rect.height);

        color = Color.WHITE;
        g2d.setColor(color);
        drawString(g2d, hud.getPauseText(), (rect.width / 2) - 170, 200);
    }

    private void paintStartScreen(Graphics2D g2d) {
        Rectangle rect = getBounds();
        Color color = Color.BLACK;
        g2d.setColor(color);
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2d.fillRect(rect.x, rect.y, rect.width, rect.height);

        color = Color.WHITE;
        g2d.setColor(color);
        drawString(g2d, hud.getStartText(), (rect.width / 2) - 170, 200);

    }

    private void drawString(Graphics2D g2d, String text, int x, int y) {
        for (String line : text.split("\n")) {
            g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
        }
    }

    private void paintGameOverScreen(Graphics2D g2d) {
        Rectangle rect = getBounds();
        Color color = Color.BLACK;
        g2d.setColor(color);
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2d.fillRect(rect.x, rect.y, rect.width, rect.height);

        color = Color.WHITE;
        g2d.setColor(color);
        drawString(g2d, hud.getGameOverText(), (rect.width / 2) - 170, 200);
    }

    private void paintWinScreen(Graphics2D g2d) {
        Rectangle rect = getBounds();
        Color color = Color.BLACK;
        g2d.setColor(color);
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2d.fillRect(rect.x, rect.y, rect.width, rect.height);

        color = Color.WHITE;
        g2d.setColor(color);
        drawString(g2d, hud.getWinText(), (rect.width / 2) - 170, 200);
    }

    private void setTextFont() {

        try {
            String fname = "src/main/resources/static/fonts/8BITWonder.ttf";
            InputStream fontFile = new BufferedInputStream(new FileInputStream(fname));
            //File fontFile = new File(fname);
            text_font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(text_font);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            switch (game_screen) {
                case START_SCREEN:
                    if (key == KeyEvent.VK_ENTER) {
                        loadGame();
                    }
                    break;
                case GAME_OVER_SCREEN:
                case WIN_SCREEN:
                    if (key == KeyEvent.VK_ENTER) {
                        game_screen = START_SCREEN;
                    }
                    break;
                case PAUSE_SCREEN:
                    if (key == KeyEvent.VK_P) {
                        game_screen = PLAY_SCREEN;
                    }
                    break;
                case PLAY_SCREEN:
                    if (player != null) {
                        player.keyPressed(e);
                    }

                    if (key == KeyEvent.VK_P) {
                        game_screen = PAUSE_SCREEN;
                    }
                    break;
            }

        }
    }

}
