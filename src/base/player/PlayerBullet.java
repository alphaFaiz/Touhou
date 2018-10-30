package base.player;

import base.GameObject;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public  PlayerBullet() {
        super();
        this.position.set(0,0);
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
    }
    int count = 0;
    @Override
    public void run() {
        this.position.addThis(0,-3);
    }
}
