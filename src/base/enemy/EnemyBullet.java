package base.enemy;

import base.GameObject;
import base.game.Setting;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    public EnemyBullet(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position.set(0, 0);
        this.renderer = new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        this.position.addThis(0, 5);
        if (this.position.y < -20 || this.position.y > Setting.BACKGROUND_IMG_HEIGHT +20
                || this.position.x < -20 || this.position.x > Setting.BACKGROUND_IMG_WIDTH + 20) {
            this.destroy();
        }
    }
}
