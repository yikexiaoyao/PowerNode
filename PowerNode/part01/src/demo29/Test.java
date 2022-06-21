package demo29;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("战士or法师");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("----------分割线----------");
        Player.FightAble(str);
    }
}
