package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {

    public Enemy() {
        super();
        this.position.set(0, 50);
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
    }


    int count = 0;
    private void fire() {
        if (count > 18) {
            EnemyBullet ebullet = new EnemyBullet();
            ebullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(ebullet);
            count = 0;
        }
        else {
            count+=1;
        }
    }

    @Override
    public void run() {
        this.fire();
    }
}


