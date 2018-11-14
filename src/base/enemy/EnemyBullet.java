package base.enemy;

import base.GameObject;
import base.game.Setting;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject implements Physics {

    BoxCollider boxCollider;
    public EnemyBullet(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position.set(0, 0);
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,5);
        this.boxCollider = new BoxCollider(this.position, 16, 16);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
        this.hitPlayer();
//        this.position.addThis(0, 5);
//        if (this.position.y < -20 || this.position.y > Setting.BACKGROUND_IMG_HEIGHT +20
//                || this.position.x < -20 || this.position.x > Setting.BACKGROUND_IMG_WIDTH + 20) {
//            this.destroy();
//        }
    }

    private void hitPlayer() {
        Player player = GameObject.intersects(Player.class, this.boxCollider);
        if (player != null) {
            if (player.health >0){
                player.health -=1;
                this.destroy();
            }
            else {
                player.destroy();
                this.destroy();
            }
        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y >= Setting.BACKGROUND_IMG_HEIGHT
                || this.position.x < 0 || this.position.x >= Setting.BACKGROUND_IMG_WIDTH) {
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
