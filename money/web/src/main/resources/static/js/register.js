//错误提示
function showError(id, msg) {
    $("#" + id + "Ok").hide();
    $("#" + id + "Err").html("<i></i><p>" + msg + "</p>");
    $("#" + id + "Err").show();
    $("#" + id).addClass("input-red");
}

//错误隐藏
function hideError(id) {
    $("#" + id + "Err").hide();
    $("#" + id + "Err").html("");
    $("#" + id).removeClass("input-red");
}

//显示成功
function showSuccess(id) {
    $("#" + id + "Err").hide();
    $("#" + id + "Err").html("");
    $("#" + id + "Ok").show();
    $("#" + id).removeClass("input-red");
}


//打开注册协议弹层
function alertBox(maskid, bosid) {
    $("#" + maskid).show();
    $("#" + bosid).show();
}

//关闭注册协议弹层
function closeBox(maskid, bosid) {
    $("#" + maskid).hide();
    $("#" + bosid).hide();
}

//注册协议确认
$(function () {
    $("#agree").click(function () {
        var ischeck = document.getElementById("agree").checked;
        if (ischeck) {
            $("#btnRegist").attr("disabled", false);
            $("#btnRegist").removeClass("fail");
        } else {
            $("#btnRegist").attr("disabled", "disabled");
            $("#btnRegist").addClass("fail");
        }
    });

    // 追踪变量
    var phone_tag = 0;

    $("#phone").blur(function () {
        phone_tag = 0;
        var phone = $.trim($("#phone").val());

        // 不能为空
        if (phone == null || phone == "0") {
            showError("phone", "手机号不能为空");
            return;
        }

        // 长度
        if (phone.length != 11) {
            showError("phone", "手机号长度不正确");
            return;
        }

        // 手机号格式
        if (!/^1[1-9]\d{9}$/.test(phone)) {
            showError("phone", "手机号不能为空");
            return;
        }

        // 是否被占用
        $.get("/web/loan/page/checkPhone", {phone: phone}, function (data) {
            if (data.code == "0") {
                showError("phone", data.message);
                phone_tag = 0;
                return;
            }

            if (data.code == "1") {
                showSuccess("phone", data.message);
                phone_tag = 1;

                // 注册
                if (phone_tag == 1 && loginPassword_tag == 1 && messageCode_tag == 1) {
                    var phone = $.trim($("#phone").val());
                    var loginPassword = $.trim($("#loginPassword").val());
                    var messageCode = $.trim($("#messageCode").val());
                    $.post("/web/loan/page/registerSubmit", {
                        phone: phone,
                        loginPassword: $.md5(loginPassword),
                        messageCode: messageCode
                    }, function (data) {
                        if (data.code == 1) {
                            window.location.href = "/web/loan/page/realName?phone=" + phone;
                        }
                        if (data.code == 0) {
                            alert(data.message);
                        }
                    });
                }
                return;
            }
        })
        showSuccess("phone");
        phone_tag = 1;
        return;
    })

    var loginPassword_tag = 0;
    $("#loginPassword").blur(function (data) {
        loginPassword_tag = 0;
        var loginPassword = $.trim($(this).val());

        //不能为空
        if (loginPassword == null || loginPassword == "") {
            showError("loginPassword", "密码不能为空");
            return;
        }

        //长度
        if (loginPassword.length < 6 || loginPassword.length > 20) {
            showError("loginPassword", "请输入6-20位有效密码");
            return;
        }

        //密码格式
        if (!/^[0-9a-zA-Z]+$/.test(loginPassword)) {
            showError("loginPassword", "密码字符只能使用数字和大小写英文字母");
            return;
        }

        if (!/^(([a-zA-Z]+[0-9]+)|([0-9]+[a-zA-Z]+))[a-zA-Z0-9]*/.test(loginPassword)) {
            showError("loginPassword", "密码应同时包含英文和数字");
            return;
        }

        showSuccess("loginPassword");
        loginPassword_tag = 1;
        return;
    })

    var messageCode_tag = 0;
    $("#messageCode").blur(function () {
        var messageCode = $.trim($("#messageCode").val());

        //不能为空
        if (messageCode == null || messageCode == "") {
            showError("messageCode", "验证码不能为空");
            return;
        }

        //长度
        if (messageCode.length != 6) {
            showError("messageCode", "请输入6位验证码");
            return;
        }

        //格式
        if (!/^(([0-9])|([1-9]([0-9]+)))$/.test(messageCode)) {
            showError("messageCode", "请输入正确的验证码");
            return;
        }
        showSuccess("messageCode");
        messageCode_tag = 1;
    })

    // 短信按钮
    $("#messageCodeBtn").click(function () {

        $("#phone").blur();
        $("#loginPassword").blur();

        if (phone_tag == 1 && loginPassword_tag == 1) {
            var phone = $.trim($("#phone").val());
            var _this = $(this);
            if (!$(this).hasClass("on")) {
                $.get("/web/loan/page/messageCode", {phone: phone}, function (data) {
                    alert(data.message);
                    $.leftTime(60, function (d) {
                        if (d.status) {
                            _this.addClass("on");
                            _this.html((d.s == "00" ? "60" : d.s) + "秒后重新获取");
                        } else {
                            _this.removeClass("on");
                            _this.html("获取验证码");
                        }
                    });
                });
            }

        }

    })

    // 注册按钮
    $("#btnRegist").click(function () {
        //验证 : 模拟事件触发
        $("#phone").blur();
        $("#loginPassword").blur();
        $("#messageCode").blur();
    })
});
