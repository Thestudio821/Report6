package jp.ac.uryukyu.ie.e195720;

public class Hero extends LivingThing {
    Hero(String name, int maximumHP, int attack, int x, int y){
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
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }
    @Override
    public void move(){
        x = x -1;
    }
}