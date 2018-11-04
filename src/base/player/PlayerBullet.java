package base.player;

import base.GameObject;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {

    public  PlayerBullet() {
        super();
        createRenderer();
//        BufferedImage image = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
//        this.renderer = new SingleImageRenderer(image);
        this.position.set(0,0);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.position.addThis(0,-7);
    }
}
