package demo27;

public class Demo04 {
    public static void main(String[] args) {
        //定义大字符串
        String max = "laoguo is a good man,laoguo is a nice man,laoguo ia a handsome man";
        //定义小字符串
        String min = "laoguo";
        //定义计数器变量
        int count = 0;
        //定义字符索引
        int index;
        //循环判断小字符串是否在大字符串中出现
        while ((index = max.indexOf(min)) != -1) {
            count++;
            //确定新的起始位置
            max = max.substring(index + min.length());
        }
        System.out.println(min + "出现了" + count + "次");
    }
}
