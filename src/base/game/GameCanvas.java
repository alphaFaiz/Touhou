package base.game;

import base.Background;
import base.GameObject;
import base.player.Player;
import base.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    GameObject background;
    GameObject player;
    public static ArrayList<PlayerBullet> bullets;
    //thêm 2 mảng enemies và enemybullets

    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        GameCanvas.bullets = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for(PlayerBullet bullet: bullets)
            bullet.render(g);
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
        for(PlayerBullet bullet: bullets) {
            bullet.run();
        }
    }
}
