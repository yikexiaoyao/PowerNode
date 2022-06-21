package demo04;

public class Demo03 {
    public static void main(String[] args) {
        String[] answers = {"A", "D", "B", "C", "D"};
        String[] stu1 = {"D", "C", "B", "A", "D"};
        String[] stu2 = {"A", "D", "B", "C", "D"};
        String[] stu3 = {"A", "D", "B", "C", "A"};
        String[] stu4 = {"A", "B", "C", "D", "D"};
        String[][] students = {stu1, stu2, stu3, stu4};
        String[] name = {"小动", "小力", "小节", "小点"};
        //外层循环控制行数，二维数组的长度 ==》 四个学生，循环四次
        for (int i = 0; i <= students.length - 1; i++) {
            System.out.print("满分" + answers.length * 2 + "分，");
            int score = 0;
            //内层循环控制列数，记录每个学生的成绩
            for (int j = 0; j <= answers.length - 1; j++) {
                //判断每个学生的答案和参考答案是否一致
                if (students[i][j] == answers[j]) {
                    score += 2;
                }
            }
            System.out.println(name[i] +"得分" + score);
        }
    }
}
