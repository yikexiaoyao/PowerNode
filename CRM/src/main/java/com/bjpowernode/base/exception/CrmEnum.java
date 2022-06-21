package com.bjpowernode.base.exception;

/**
 * @author cty
 * @date 2021/10/24 22:39
 */
public enum CrmEnum {

    USER_LOGIN_USERNAME_PASSWORD("001-001-001", "用户名或密码错误"),
    USER_LOGIN_ERROR_CODE("001-001-002", "用验证码错误"),
    USER_LOGIN_EXPIRED_TIME("001-001-003", "账号失效，请联系管理员"),
    USER_LOGIN_LOCKED_STATE("001-001-004", "账号被锁定，请联系管理员"),
    USER_LOGIN_ALLOWED_IP("001-001-005", "不允许登录的IP，请联系管理员"),
    USER_UPDATE_PASSWORD("001-002-001", "原始密码输入错误"),
    USER_UPDATE_INFO("001-002-002", "用户信息更新失败"),
    USER_UPDATE_MAXSIZE("001-002-003", "上传文件不能超过2M"),
    USER_UPDATE_SUFFIX("001-002-004", "只允许上传png,jpg,jpeg,gif,webp后缀的文件"),
    ACTIVITY_SAVE("002-001-001", "添加市场活动失败"),
    ACTIVITY_UPDATE("002-001-002", "修改市场活动失败"),
    CLUE_SAVE("002-002-001", "添加线索失败"),
    CLUE_UPDATE("002-002-002", "修改线索失败"),
    CUSTOMER_SAVE("002-003-001", "添加客户失败"),
    CUSTOMER_UPDATE("002-003-002", "修改客户失败"),
    CONTACT_SAVE("002-004-001", "添加联系人失败"),
    CONTACT_UPDATE("002-004-002", "修改联系人失败"),
    TRAN_SAVE("002-005-001", "添加交易失败"),
    TRAN_UPDATE("002-005-002", "修改交易失败");

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
}
