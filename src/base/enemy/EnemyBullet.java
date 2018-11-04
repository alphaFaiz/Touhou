package base.enemy;

import base.GameObject;
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
    }
}
