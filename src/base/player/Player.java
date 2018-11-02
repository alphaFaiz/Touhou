package base.player;

import base.Background;
import base.enemy.Enemy;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Setting;
import tklibs.SpriteUtils;

public class Player extends GameObject {

    int count = 0;

    public Player(){
        super();
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200, 300);
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
            if (this.position.y< Setting.SCREEN_HEIGHT - this.image.getHeight())
            this.position.addThis(0,4);
        }

        if(KeyEventPress.isRightPress) {
            if( this.position.x< new Background().image.getWidth() -this.image.getWidth())
            this.position.addThis(4,0);
        }

        if ((KeyEventPress.isFirePress)) {
            this.fire();
        }

    }

    private void fire() {
        if (count > 2) {
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
