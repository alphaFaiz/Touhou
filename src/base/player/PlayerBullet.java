package base.player;

import base.GameObject;
import base.game.Setting;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {

    public  PlayerBullet() {
        super();
        this.position.set(0,0);
        this.velocity.set(0,-5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
//        this.position.addThis(0,-7);
//        if (this.position.y < -20 || this.position.y > Setting.BACKGROUND_IMG_HEIGHT +20
//                || this.position.x < -20 || this.position.x > Setting.BACKGROUND_IMG_WIDTH + 20) {
//            this.destroy();
//        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y >= Setting.BACKGROUND_IMG_HEIGHT
                || this.position.x < 0 || this.position.x >= Setting.BACKGROUND_IMG_WIDTH) {
            this.destroy();
        }
    }
}
