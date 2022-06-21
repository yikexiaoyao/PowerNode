package demo29;

//法师
public class Mage implements FightAble {
    @Override
    public void specialFight() {
        System.out.println("法术攻击");
    }
}
