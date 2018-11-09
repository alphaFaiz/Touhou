package base;

import base.player.Player;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static Player createPlayer() {
        Player player = new Player();
        gameObjects.add(player);
        return player;
    }

    //createGameObject, dùng generic
    public static <E extends GameObject> E create(Class<E> clazz) {
        try {
            E gameObject = clazz.newInstance(); // = new E();
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex) {
            return null;
        }
    }
    //recycle
    public static <E extends GameObject> E recycle(Class<E> clazz) {
        for (GameObject gameObject: gameObjects) {
            if (isValidRecycle(gameObject, clazz)) {
                gameObject.reset();
                return (E)gameObject;
            }
        }
        E newGameObject = create(clazz);
        return newGameObject;
    }

    private static boolean isValidRecycle(GameObject gameObject, Class clazz) {
        //gameObject.isActive == false
        //gameObject instanceof clazz
        return !gameObject.isActive && gameObject.getClass().isAssignableFrom(clazz);
    }

    //thuộc tính
    public Renderer renderer;
    public Vector2D position;
    public boolean isActive;

    //phương thức
    public  GameObject(){
        this.position = new Vector2D();
        this.isActive = true;
    }

    public void destroy() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
    }

    public  void  run(){
    }

    public  void render(Graphics g){
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }
}
