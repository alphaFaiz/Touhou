package base;

import tklibs.SpriteUtils;

import java.awt.*;

public class Background extends GameObject {
    public  Background(){
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.y = 600 - this.image.getHeight();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    @Override
    public void run() {
        if(this.y<0)
        this.y++;
    }
}
