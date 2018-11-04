package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //thuộc tính
    public Renderer renderer;
    public Vector2D position = new Vector2D();

    //phương thức
    public  GameObject(){
        this.position = new Vector2D();
    }

    public  void  run(){
    }

    public  void render(Graphics g){
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

}
