package demo18;

import org.junit.*;

public class Demo {
    @Test
    public void show(){
        System.out.println("show run ...");
    }
    @Test
    public void demo(){
        int method = method(10);
        System.out.println("method=" + method);
        System.out.println("demo run ...");
    }
    public int method(int a){
        return a;
    }
    @After
    public void after() {
        System.out.println("after run ...");
    }
    @Before
    public void before() {
        System.out.println("before run ...");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass run ...");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass run ...");
    }
}
