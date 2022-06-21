package demo07;

public class Demo_System {
    public static void main(String[] args) {
        //获取文件名分隔符
        String file_separator = System.getProperty("file.separator");
        System.out.println(file_separator);

        //获取路径名分隔符
        String path_separator = System.getProperty("path.separator");
        System.out.println(path_separator);

        //获取行分隔符
        String line = System.getProperty("line.separator");
        System.out.println("床前明月光\r\n疑是地上霜\n举头望明月\n低头思故乡");
        System.out.println("床前明月光" + line + "疑是地上霜" + line + "举头望明月" + line + "低头思故乡");

        //JDK1.7获取行分隔符
        String lineSeparator = System.lineSeparator();
        System.out.println("床前明月光" + lineSeparator + "疑是地上霜" + lineSeparator + "举头望明月" + lineSeparator + "低头思故乡");
    }
}
