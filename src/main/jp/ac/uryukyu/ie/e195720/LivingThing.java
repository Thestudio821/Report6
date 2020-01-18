package jp.ac.uryukyu.ie.e195720;

/**
 * 対象の基本ステータス
 * 名称、HP、攻撃力、被倒時の経験値
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;

    private boolean dead;
    int x;
    int y;


    LivingThing(String name, int maximumHP, int attack, int x,int y) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        this.x = x;
        this.y = y;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    boolean getDead() {
        return !dead;
    }

    void setDead(boolean dead){
        this.dead = dead;
    }
    String getName() {
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
}