package jp.ac.uryukyu.ie.e195720;

import javax.swing.JPanel;
import java.awt.*;

public class Paint extends JPanel {
    //画像のパス
    String pass = "/Users/e195720/Image/";
    Image slime = Toolkit.getDefaultToolkit().getImage(pass + "boss.png");
    Image dog = Toolkit.getDefaultToolkit().getImage(pass + "kerube.png");

    // パネルサイズ
    private static final int WIDTH = 800;
    private static final int HEIGHT = 240;
    //画像の座標
    int Mx = 780;  //Mの初期座標
    int My = 50;
    int Ex = 20; //Eの初期座標
    int Ey = 50;
    int Mw = 780; //Mの勝利条件
    int Ew = 20;  //Eの勝利条件

    public Paint() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(slime, Ex, Ey, 100, 100, this);
        g.drawImage(dog, Mx, My, -100, 100, this);
        move();
    }


    public void move() {
        repaint();
        Ex = Ex + 1;
        Mx = Mx - 1;

        try {
            Thread.sleep(10); //　アニメーションらしくするため
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


