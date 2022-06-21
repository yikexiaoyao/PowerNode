package demo18;

class MyDate {
    int year;
    int month;
    int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public MyDate() {}
    public String getInfo() {
        return year + "-" + month + "-" + day;
    }
}
public class Test01 {
    public static void main(String[] args) {
        MyDate md1 = new MyDate(1999, 3, 26);
        MyDate md2 = new MyDate(2021, 7, 30);
        MyDate md3 = new MyDate(2022, 1, 30);
        System.out.println("生日：" + md1.getInfo());
        System.out.println("报名时间：" + md2.getInfo());
        System.out.println("毕业时间：" + md3.getInfo());
    }
}
