package demo25;

/**
 * @author cty
 * @date 2021/9/3 8:39
 */
public class Peson {
    String name;
    int age;
    char sex;

    public Peson(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Peson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new WrongNameException("姓名不能为空");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            throw new WrongAgeException("年龄不合法");
        }
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if (sex != '男' || sex != '女') {
            throw new WrongSexException("性别不合法");
        }
        this.sex = sex;
    }

}

class WrongNameException extends RuntimeException {
    WrongNameException(String Msg) {
        super(Msg);
    }
}

class WrongAgeException extends RuntimeException {
    WrongAgeException(String Msg) {
        super(Msg);
    }
}

class WrongSexException extends RuntimeException {
    WrongSexException(String Msg) {
        super(Msg);
    }
}
