package demo18;

class Citizen {
    String name;
    MyDate birthday;
    String idNumber;
    public Citizen(String name, MyDate birthday, String idNumber) {
        this.name = name;
        this.birthday = birthday;
        this.idNumber = idNumber;
    }
    public Citizen() {}
    public void getInfo() {
        System.out.println("姓名：" + name + "，生日：" + birthday.getInfo() +"，身份证号：" + idNumber);
    }
}
public class Test02 {
    public static void main(String[] args) {
        MyDate md1 = new MyDate(1975, 1, 1);
        MyDate md2 = new MyDate(1976, 1, 1);
        MyDate md3 = new MyDate(1999, 1, 1);
        Citizen c1 = new Citizen("父亲", md1, "123456789");
        Citizen c2 = new Citizen("母亲", md2, "987654321");
        Citizen c3 = new Citizen("我", md3, "123454321");
        c1.getInfo();
        c2.getInfo();
        c3.getInfo();
    }
}
