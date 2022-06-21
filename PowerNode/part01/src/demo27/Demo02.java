package demo27;

public class Demo02 {
    public static void main(String[] args) {
        String s = "ABCDEabcd123456!@#$%^";
        //将字符串转换为数组
        char[] arr = s.toCharArray();
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((byte) (arr[i]) >= 65 && (byte) (arr[i]) <= 90) {
                //A~Z
                a++;
            } else if ((byte) (arr[i]) >= 97 && (byte) (arr[i]) <= 122) {
                //a~z
                b++;
            } else if ((byte) (arr[i]) >= 48 && (byte) (arr[i]) <= 57) {
                //0~9
                c++;
            } else {
                //其他
                d++;
            }
        }
        System.out.println("大写字母" + a + "个");
        System.out.println("小写字母" + b + "个");
        System.out.println("数字" + c + "个");
        System.out.println("字符" + d + "个");
    }
}
