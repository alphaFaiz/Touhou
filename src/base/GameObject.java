package base;

import base.enemy.Enemy;
import base.physics.BoxCollider;
import base.physics.Physics;
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
    /*
    trả về 1 gameObject có kiểu clazz<E> intersect với gameObject
     */
    public static <E extends GameObject> E intersects(Class<E> clazz, BoxCollider boxCollider) {
        //tìm trong gameObjects kết quả result thỏa mãn instanceof E và instanceof Physics
        //result.getBoxCollider.intersects(boxCollider)
        int size = gameObjects.size();
        for (int i = 0; i < size; i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive
                && gameObject.getClass().isAssignableFrom(clazz)
                && gameObject instanceof Physics) {
                Physics gameObjectPhysics = (Physics) gameObject;
                if (gameObjectPhysics.getBoxCollider().intersects(boxCollider)) {
                    return (E) gameObject;
                }
            }
        }
        return null;
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
    public Vector2D velocity;

    //phương thức
    public  GameObject(){
        this.position = new Vector2D();
        this.isActive = true;
        this.velocity = new Vector2D();
    }

    public void destroy() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
    }

    public  void  run(){
        this.position.addThis(this.velocity);
    }

    public  void render(Graphics g){
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

}
