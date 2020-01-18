package jp.ac.uryukyu.ie.e195720;
public class Enemy extends LivingThing{
    Enemy(String name, int maximumHP, int attack, int x, int y){
        super(name, maximumHP, attack, x, y);
    }

    @Override
    public void wounded(int damage){
        String name = getName();
        int hitPoint = getHitPoint();
        hitPoint -= damage;
        setHitPoint(hitPoint);
        if( hitPoint <= 0 ) {
            setDead(true);
            System.out.printf("%sは倒れた。\n", name);
        }
    }
    @Override
    public void move(){
        x = x + 1;
    }

}