package base.player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.game.Setting;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.BoxRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    public int health;
    public Player(){
        super();
        this.createRenderer();
        this.position.set(200, 300);
        this.fireCounter = new FrameCounter(10);
        this.boxCollider = new BoxCollider(this.position,32,48);
        //homework
        this.health = 3;
        //this.renderer = new BoxRenderer(boxCollider);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.move();
        if (this.fireCounter.run() && (KeyEventPress.isFirePress)) {
            this.fire();
        }
        super.run();
    }

    private void move() {
        int vx = 0;
        int vy = 0;
        if(KeyEventPress.isUpPress) {
            if (this.position.y>0)
                vy -= 4;
        }

        if(KeyEventPress.isLeftPress) {
            if (this.position.x>0)
                vx -= 4;
        }

        if(KeyEventPress.isDownPress) {
            if (this.position.y< Setting.SCREEN_HEIGHT - Setting.PLAYER_IMG_HEIGHT)
                vy += 4;
        }

        if(KeyEventPress.isRightPress) {
            if( this.position.x< Setting.BACKGROUND_IMG_WIDTH - Setting.PLAYER_IMG_WIDTH)
                vx += 4;
        }
        this.velocity.set(vx,vy);


    }

    private void fire() {
            PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
            bullet.position.set(this.position.add(15,0));
            //thêm hướng đạn khác
//            HomingBullet homingBullet = GameObject.recycle(HomingBullet.class);
//            homingBullet.position.set(this.position);
            PlayerBulletType2 playerBulletType2 = GameObject.recycle(PlayerBulletType2.class);
            playerBulletType2.position.set(this.position.add(-15,0));
            playerBulletType2.velocity.set(-5, -5);
            //
            this.fireCounter.reset();
    }

    @Override
    public void destroy() {
        super.destroy();
        PlayerExplosion playerExplosion = GameObject.recycle(PlayerExplosion.class);
        playerExplosion.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
