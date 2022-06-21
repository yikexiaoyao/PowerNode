package enity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * @author cty
 * @date 2021/9/23 11:26
 */
public class Student implements Serializable, HttpSessionBindingListener {
    private int id;
    private String sname;
    private int age;
    private String gender;
    private String address;
    private String remark;

    public Student(int id, String sname, int age, String gender, String address, String remark) {
        this.id = id;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.remark = remark;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Student value = (Student) event.getValue();
        System.out.println(name + ":" + value.getSname());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Student value = (Student) event.getValue();
        System.out.println(name + ":" + value.getSname() + "被删除了");
    }
}
