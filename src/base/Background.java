package base;

import base.game.Setting;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public  Background(){
        super();
        BufferedImage image = SpriteUtils.loadImage(
                "assets/images/background/0.png");
        Setting.BACKGROUND_IMG_HEIGHT = image.getHeight();
        Setting.BACKGROUND_IMG_WIDTH = image.getWidth();
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, Setting.SCREEN_HEIGHT - image.getHeight());
    }

    @Override
    public void run() {
        if(this.position.y<0) {
            this.position.addThis(0,3);
        }

        //loop background
//        if(this.position.y >=0) {
//            this.position.set(0, Setting.SCREEN_HEIGHT - Setting.BACKGROUND_IMG_HEIGHT);
//        }

    }
}
