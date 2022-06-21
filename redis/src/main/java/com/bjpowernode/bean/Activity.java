package com.bjpowernode.bean;

/**
 * @author cty
 * @date 2021/11/23 16:06
 */
public class Activity {
    private String name;
    private String createBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
