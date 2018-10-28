package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuộc tính
    BufferedImage image;
    int x;
    int y;

    //phương thức
    public  GameObject(){

    }

    public  void  run(){
    }

    public  void render(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }

}
