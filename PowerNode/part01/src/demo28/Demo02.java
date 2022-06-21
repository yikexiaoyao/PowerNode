package demo28;

import java.util.Arrays;
import java.util.Comparator;

//员工
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Demo02 {
    public static void main(String[] args) {

        Employee[] emps = new Employee[3];
        emps[0] = new Employee(2, "张三", 8000.0);
        emps[1] = new Employee(1, "李四", 10000.0);
        emps[2] = new Employee(3, "王五", 12000.0);

        System.out.println("排序前：");
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }

        System.out.println("----------分割线----------");

        //升序
        Arrays.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getId() - emp2.getId();
            }
        });

        System.out.println("排序后：（升序）");
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }

        System.out.println("----------分割线----------");

        //降序
        Arrays.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //返回正数
                return (int) (emp2.getSalary() - emp1.getSalary());
            }
        });

        System.out.println("排序后：（降序）");
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }

    }
}
