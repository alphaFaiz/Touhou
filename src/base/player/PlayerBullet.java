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
        this.createRenderer();
        this.position.set(0,0);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
                );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.position.addThis(0,-7);
        if (this.position.y < -20 || this.position.y > Setting.BACKGROUND_IMG_HEIGHT +20
                || this.position.x < -20 || this.position.x > Setting.BACKGROUND_IMG_WIDTH + 20) {
            this.destroy();
        }
    }
}
