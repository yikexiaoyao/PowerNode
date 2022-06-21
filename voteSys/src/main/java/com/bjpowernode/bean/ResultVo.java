package com.bjpowernode.bean;

/**
 * @author cty
 * @date 2021/11/27 15:29
 */
public class ResultVo {
    private boolean isOk;
    private String message;

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "isOk=" + isOk +
                ", message='" + message + '\'' +
                '}';
    }
}
