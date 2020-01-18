package jp.ac.uryukyu.ie.e195720;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        // タイトルを設定
        setTitle("ワンワン戦線");

        // メインパネルを作成してフレームに追加
        LivingThing panel = new LivingThing();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        // パネルサイズに合わせてフレームサイズを自動設定
        pack();
    }

    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 10, 5, 780,50);
        Enemy enemy = new Enemy("スライム", 6, 3, 20,50);

        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(enemy.getX());
        System.out.println(hero.getX());

        while (true){
            hero.move();
            enemy.move();

            if (hero.getX() == enemy.getX()){
                while( hero.getDead() && enemy.getDead()) {
                    hero.attack(enemy);
                    enemy.attack(hero);
                }
            }
        }
    }
}