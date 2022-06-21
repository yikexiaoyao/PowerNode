package demo29;

//玩家
public class Player {
    public static void FightAble(String str) {
        String Warrior = "战士";
        String Mage = "法师";
        FightAble w = new Warrior();
        FightAble m = new Mage();
        if (str.equals(Warrior)) {
            w.specialFight();
            w.commonFight();
        } else if (str.equals(Mage)) {
            m.specialFight();
            m.commonFight();
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }
}
