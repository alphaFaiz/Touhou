package base.game;

import base.Background;
import base.GameObject;
import base.enemy.Enemy;
import base.enemy.EnemyBullet;
import base.player.Player;
import base.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    GameObject background;
    GameObject player;
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<EnemyBullet> enemyBullets;
    //thêm 2 mảng enemies và enemybullets

    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        GameCanvas.bullets = new ArrayList<>();
        GameCanvas.enemies = new ArrayList<>();
        GameCanvas.enemyBullets = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for(PlayerBullet bullet: bullets) {
            bullet.render(g);
        }
        for (Enemy enemy: enemies) {
            enemy.render(g);
        }
        for (EnemyBullet ebullet: enemyBullets) {
            ebullet.render(g);
        }
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
        for (Enemy enemy: enemies) {
            enemy.run();
        }
        for (EnemyBullet ebullet: enemyBullets) {
            ebullet.run();
        }
    }

    public void createEnemy() {
        Enemy enemy = new Enemy();
        enemy.position.x = (int) ( new Background().image.getWidth() * Math.random() );
        GameCanvas.enemies.add(enemy);
    }
}
