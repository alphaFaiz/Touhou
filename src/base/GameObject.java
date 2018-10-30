package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuộc tính
    public BufferedImage image;
//    int x;
//    int y;
    public Vector2D position = new Vector2D();

    //phương thức
    public  GameObject(){
        this.position = new Vector2D();
    }

    public  void  run(){
    }

    public  void render(Graphics g){
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

}
