package base.enemy;

import base.Background;
import base.FrameCounter;
import base.GameObject;
import base.game.GameCanvas;
import base.game.Setting;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter fireCounter;
    public Enemy() {
        super();
        this.createRenderer();
        this.position.set(100, 100);
        this.fireCounter = new FrameCounter(20);
        this.velocity.set(0,3);
        this.boxCollider = new BoxCollider(this.position, 34, 50);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
              "assets/images/enemies/level0/black/0.png",
              "assets/images/enemies/level0/black/1.png",
              "assets/images/enemies/level0/black/2.png",
              "assets/images/enemies/level0/black/4.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    private void fire() {
        if (this.fireCounter.run()) {
            EnemyBullet ebullet = GameObject.recycle(EnemyBullet.class);
            ebullet.position.set(this.position);
            this.fireCounter.reset();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion= GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }

    float startXPosition = this.position.x;
    float startYPosition = this.position.y;
    @Override
    public void run() {
        super.run();
        if (this.position.y >= 300) {
            this.velocity.set(0,0);
        }

    //Todo: replace velocity in enemy movement
//        if (startYPosition < 100) {
//            this.position.addThis(0, 3);
//        }
//        if (this.position.y <= 0 || this.position.y >= 100) {
//            startYPosition = this.position.y;
//        }
//        if (startYPosition >= 100) {
//            this.position.addThis(0,-3);
//        }
//
//        if (startXPosition >= 0 && startXPosition < Setting.BACKGROUND_IMG_WIDTH - Setting.ENEMY_IMG_WIDTH) {
//            this.position.addThis(2, 0);
//        }
//        if (this.position.x >= Setting.BACKGROUND_IMG_WIDTH - Setting.ENEMY_IMG_WIDTH || this.position.x <= 0) {
//            startXPosition = this.position.x;
//        }
//        if (startXPosition >= Setting.BACKGROUND_IMG_WIDTH - Setting.ENEMY_IMG_WIDTH) {
//            this.position.addThis(-2,0);
//        }

        this.fire();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}


