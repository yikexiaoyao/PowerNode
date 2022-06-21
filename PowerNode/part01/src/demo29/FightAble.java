package demo29;

//攻击接口
public interface FightAble {
    abstract void specialFight();

    default void commonFight() {
        System.out.println("普通攻击");
    }
}
