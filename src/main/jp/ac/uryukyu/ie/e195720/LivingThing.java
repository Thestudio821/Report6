package jp.ac.uryukyu.ie.e195720;

import javax.swing.*;
import java.awt.*;

/**
 * 対象の基本ステータス
 * 名称、HP、攻撃力、被倒時の経験値
 */
public class LivingThing extends JPanel {
    private String name;
    private int hitPoint;
    private int attack;

    private boolean dead;
    int x;
    int y;

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


    LivingThing(String name, int maximumHP, int attack, int x,int y) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        this.x = x;
        this.y = y;


        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    LivingThing(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    boolean getDead() {
        return !dead;
    }

    void setDead(boolean dead){
        this.dead = dead;
    }
    public String getName() {
        return name;
    }

    int getHitPoint() {
        return hitPoint;
    }
    void setHitPoint(int HP) {
        this.hitPoint = HP;
    }



    public int getY() {return y;}
    public int getX() {return x;}

    public void move(){
        x = x +1;
    }

    /**
     * HPが0になるまで攻撃するよ
     * @param opponent
     * 攻撃の対象。
     */
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        if (hitPoint > 0) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * HPが0以下になると負け（死亡）する
     * @param damage
     * attackを実行した時に生成された相手にダメージを与える値
     */
    public void wounded(int damage) {
        String name = getName();
        int y = getY();
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            y = y + 100;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(slime, Ex, Ey, 100, 100, this);
        g.drawImage(dog, Mx, My, -100, 100, this);
        sleep();
    }


    public void sleep() {
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