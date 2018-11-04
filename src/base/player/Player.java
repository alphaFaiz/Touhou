package base.player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Setting;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {

    int count = 0;

    public Player(){
        super();
        createRenderer();
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        this.renderer = new SingleImageRenderer(image);
//        Setting.PLAYER_IMAGE_WIDTH = image.getWidth();
//        Setting.PLAYER_IMAGE_HEIGHT = image.getHeight();

        this.position.set(200, 300);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            if (this.position.y>0)
            this.position.subtractThis(0,4);
        }

        if(KeyEventPress.isLeftPress) {
            if (this.position.x>0)
            this.position.subtractThis(4, 0);
        }

        if(KeyEventPress.isDownPress) {
            if (this.position.y< Setting.SCREEN_HEIGHT - Setting.PLAYER_IMG_HEIGHT)
            this.position.addThis(0,4);
        }

        if(KeyEventPress.isRightPress) {
            if( this.position.x< Setting.BACKGROUND_IMG_WIDTH - Setting.PLAYER_IMG_WIDTH)
            this.position.addThis(4,0);
        }

        if ((KeyEventPress.isFirePress)) {
            this.fire();
        }

    }

    private void fire() {
        if (count >= 10) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            GameCanvas.bullets.add(bullet);
            count = 0;
        }
        else {
            count+=1;
        }
    }
}
