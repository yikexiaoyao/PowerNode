package demo27;

public class Demo03 {
    public static void main(String[] args) {
        //定义字符串
        String s = "woaiLAOGUOailaoguo";
        //获取字符串中的第一个字符
        String str1 = s.substring(0, 1);
        //获取字符串中除第一个字符以外的其他字符
        String str2 = s.substring(1);
        //转换成大写
        str1 = str1.toUpperCase();
        //转换成小写
        str2 = str2.toLowerCase();
        //字符串拼接 ==> str1 + str2
        String content = str1.concat(str2);
        //
        System.out.println(content);
    }
}
