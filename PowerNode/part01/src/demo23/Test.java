package demo23;

public class Test {
    public static void main(String[] args) {
        //表示普通员工
        int EMPLOYEE = 10;
        //表示程序员
        int PROGRAMMER = 11;
        //表示设计师
        int DESIGNER = 12;
        //表示架构师
        int ARCHITECT = 13;

        String[][] EMPLOYEES = {
                {"10", "1", "段誉", "22", "3000"},
                {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
                {"11", "3", "任我行", "23", "7000"},
                {"11", "4", "张三丰", "24", "7300"},
                {"12", "5", "周芷若", "28", "10000", "5000"},
                {"11", "6", "赵敏", "22", "6800"},
                {"12", "7", "张无忌", "29", "10800", "5200"},
                {"13", "8", "韦小宝", "30", "19800", "15000", "2500"},
                {"12", "9", "杨过", "26", "9800", "5500"},
                {"11", "10", "小龙女", "21", "6600"},
                {"11", "11", "郭靖", "25", "7100"},
                {"12", "12", "黄蓉", "27", "9600", "4800"}
        };

        //定义员工数组
        Employee[] emps = new Employee[EMPLOYEES.length];

        //遍历二维数组，处理每一个一维数组(表示每一个员工的信息)
        for (int i = 0; i < EMPLOYEES.length; i++) {
            int num = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            //判断员工是何工种
            if (num == 10) {
                //说明是一个普通员工
                emps[i] = new Employee(id, name, age, salary);
            } else if (num == 11) {
                //说明是一个程序员
                emps[i] = new Programmer(id, name, age, salary);
            } else if (num == 12) {
                //说明是一个设计师
                //解析bonus数据
                double bonus = Double.parseDouble(EMPLOYEES[i][5]);
                emps[i] = new Designer(id, name, age, salary, bonus);
            } else if (num == 13) {
                //说明是一个架构师
                //解析bonus、stock数据
                double bonus = Double.parseDouble(EMPLOYEES[i][5]);
                int stock = Integer.parseInt(EMPLOYEES[i][6]);
                emps[i] = new Architect(id, name, age, salary, bonus, stock);
            }
        }
        //打印表头信息
        System.out.println("编号\t姓名\t年龄\t薪资\t语言\t奖金\t股票");
        //遍历员工数组(emps)
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].getInfo());
        }
    }
}
