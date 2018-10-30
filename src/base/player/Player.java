package base.player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    public Player(){
        super();
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200, 300);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
           // if (this.y<600)
            this.position.subtractThis(0,3);
        }

        if(KeyEventPress.isLeftPress) {
            this.position.subtractThis(3, 0);
        }

        if(KeyEventPress.isDownPress) {
            this.position.addThis(0,3);
        }

        if(KeyEventPress.isRightPress) {
          //  if( this.x<384)
            this.position.addThis(3,0);
        }

        if ((KeyEventPress.isFirePress)) {
            this.fire();
        }
    }

    private void fire() {
        int count = 0;
        if (count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            GameCanvas.bullets.add(bullet);
            count = 0;
        }
        else {
            count++;
        }
    }
}
