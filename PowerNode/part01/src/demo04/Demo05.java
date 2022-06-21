package demo04;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        System.out.println("请输入组数");
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        System.out.println("请输入每组人数");
        int stuNum = scanner.nextInt();
        //创建数组
        int[] group = new int[groupNum];
        int[] stu = new int[stuNum];
        int[][] scores = new int[groupNum][stuNum];
        //保存数据
        for (int i = 0; i < groupNum; i++) {
            for (int j = 0; j < stuNum; j++) {
                System.out.println("请输入第" + (i + 1) + "组第" + (j + 1) + "个学生的成绩");
                scores[i][j] = scanner.nextInt();
            }
        }

        //每组最高分、最低分
        for (int i = 0; i < groupNum; i++) {
            int maxGroup = scores[0][0];
            int minGroup = scores[0][0];
            for (int j = 0; j < stuNum; j++) {
                if (maxGroup < scores[i][j]) {
                    //算出最大值
                    maxGroup = scores[i][j];
                }
                if (minGroup > scores[i][j]) {
                    //算出最小值
                    minGroup = scores[i][j];
                }
            }
            System.out.println("第" + (i + 1) + "组最高峰分：" + maxGroup);
            System.out.println("第" + (i + 1) + "组最低峰分：" + minGroup);
        }

        //每组平均分
        for (int i = 0; i < groupNum; i++) {
            int sumGroup = 0;
            double avgGroup = 0;
            for (int j = 0; j < stuNum; j++) {
                sumGroup += scores[i][j];
            }
            avgGroup = sumGroup / stu.length;
            System.out.println("第" + (i + 1) + "组平均分：" + avgGroup);
        }

        //全班最高分、最低分
        int maxClass = scores[0][0];
        int minClass = scores[0][0];
        for (int i = 0; i < groupNum; i++) {
            for (int j = 0; j < stuNum; j++) {
                if (maxClass < scores[i][j]) {
                    //算出最大值
                    maxClass = scores[i][j];
                }
                if (minClass > scores[i][j]) {
                    //算出最小值
                    minClass = scores[i][j];
                }
            }
        }
        System.out.println("最高峰分：" + maxClass);
        System.out.println("最低峰分：" + minClass);

        //全班平均分
        int sumClass = 0;
        double avgClass = 0;
        for (int i = 0; i < groupNum; i++) {
            for (int j = 0; j < stuNum; j++) {
                sumClass += scores[i][j];
            }
        }
        avgClass = sumClass / (group.length * stu.length);
        System.out.println("全班平均分：" + avgClass);
        System.out.println("全班总人数：" + group.length * stu.length);
    }
}
