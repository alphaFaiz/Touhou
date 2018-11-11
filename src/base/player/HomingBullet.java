package base.player;

import base.GameObject;
import base.enemy.Enemy;
import base.game.Setting;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HomingBullet extends GameObject {
    public HomingBullet() {
        super();
        this.createRenderer();
        this.position.set(0,0);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/red.png",
                "assets/images/enemies/bullets/green.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if (this.position.y < GameObject.gameObjects.get(2).position.y)
        this.position.addThis(0,5);
        if (this.position.y > GameObject.gameObjects.get(2).position.y)
            this.position.addThis(0,-5);
        if (this.position.x < GameObject.gameObjects.get(2).position.x)
            this.position.addThis(5,0);
        if (this.position.x > GameObject.gameObjects.get(2).position.x)
            this.position.addThis(-5,0);
        if (this.position == GameObject.gameObjects.get(2).position || this.position.y < -20 ||
                this.position.y > Setting.BACKGROUND_IMG_HEIGHT +20
                || this.position.x < -20 || this.position.x > Setting.BACKGROUND_IMG_WIDTH + 20) {
            this.destroy();
        }
    }

}
