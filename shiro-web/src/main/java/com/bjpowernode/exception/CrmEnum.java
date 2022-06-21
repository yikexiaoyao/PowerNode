package com.bjpowernode.exception;

/**
 * @author cty
 * @date 2021/12/9 18:38
 */
public enum CrmEnum {
    ;
    private String code;    //业务状态码
    private String message; //放在异常堆栈中

    CrmEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CrmEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
