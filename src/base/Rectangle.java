package base;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle() {
        this(new Vector2D(), 5, 5);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    //TODO
    public boolean intersects(Rectangle other) {
        if(
                (other.position.x >= this.position.x && other.position.y >= this.position.y && other.position.x <= this.position.x + this.width && other.position.y <= this.position.y +this.height )
        || (this.position.x >= other.position.x && this.position.y >= other.position.y && this.position.x <= other.position.x + other.width && this.position.y <= other.position.y + other.height )
        )
        return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(0,0),10,10);
        Rectangle rect2 = new Rectangle(new Vector2D(5,5),10,10);
        Rectangle rect3 = new Rectangle(new Vector2D(5,-15),10,10);
        Rectangle rect4 = new Rectangle(new Vector2D(0,-15),10,10);

        System.out.println(rect2.intersects(rect1));
        System.out.println(rect1.intersects(rect3));
        System.out.println(rect3.intersects(rect4));
        System.out.println(rect2.intersects(rect3));
    }
}
