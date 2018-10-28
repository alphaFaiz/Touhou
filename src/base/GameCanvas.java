package base;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    GameObject background;
    GameObject player;
    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
    }

    public void gameLoop(){
        int delay = 1000 / 60;
        long lastRun = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    private void renderAll() {
        this.repaint();
    }

    private void runAll() {
        this.background.run();
        this.player.run();
    }
}
