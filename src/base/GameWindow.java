package base;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//dừng chương trình khi đóng cửa sổ

        this.setSize(800,600);
        this.setTitle("Touhou");
        this.setResizable(false); //không cho thay đổi windowsize
    }
}
