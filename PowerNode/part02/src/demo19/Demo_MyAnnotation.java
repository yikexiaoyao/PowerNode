package demo19;

//@MyAnnotation(name = "张三")
public class Demo_MyAnnotation {
    //成员变量
    @MyAnnotation(name = "李四", age = 20)
    int num = 10;

    //构造方法
    @MyAnnotation(name = "王五")
    public Demo_MyAnnotation(int num) {
        this.num = num;
    }

    //成员方法
    @MyAnnotation(name = "赵六")
    public static void main(/*@MyAnnotation(name = "王八")*/ String[] args) {
        //局部变量
        //@MyAnnotation(name = "田七")
        int a = 100;
    }
}

//@MyAnnotation(name = "小九")
@MyValue("value变量在使用时，可以省略变量名...")
interface Inter {

}
