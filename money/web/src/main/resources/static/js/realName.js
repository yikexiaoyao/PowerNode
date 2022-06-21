//同意实名认证协议
$(function () {
    $("#agree").click(function () {
        var ischeck = document.getElementById("agree").checked;

        if (ischeck) {
            $("#btnVerify").attr("disabled", false);
            $("#btnVerify").removeClass("fail");
        } else {
            $("#btnVerify").attr("disabled", "disabled");
            $("#btnVerify").addClass("fail");
        }

    });
});

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

/**
 * 虚拟点击事件
 */
function btnClick() {
    $('#codeImg').trigger('click');
}

$(function () {
    // 页面加载完执行模拟点击事件
    window.onload = btnClick;

    //图形验证码
    $("#codeImg").click(function () {
        $(this).prop("src", "/web/codeImg?date=" + new Date());
    });

    //验证：姓名
    $("#realName").blur(function () {
        var realName = $.trim($("#realName").val());

        //不能为空
        if (realName == null || realName == "") {
            showError("realName", "姓名不能为空");
            return;
        }

        //格式  ^[\u4e00-\u9fa5]{0,}$
        if (!/^[\u4e00-\u9fa5]{0,}$/.test(realName)) {
            showError("realName", "请输入正确中文姓名");
            return;
        }
        showSuccess("realName");
    });

    $("#idCard").blur(function () {
        var idCard = $.trim($("#idCard").val());

        //不能为空
        if (idCard == null || idCard == "") {
            showError("idCard", "身份证号码不能为空");
            return;
        }

        //格式  ^[\u4e00-\u9fa5]{0,}$
        if (!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(idCard)) {
            showError("idCard", "请输入正确的身份证号码");
            return;
        }
        showSuccess("idCard");
    });

    /*$("#messageCodeBtn").click(function () {
        // 验证手机号码 姓名 身份证
        var phone = $.trim($("#phone").val());
        var _this = $(this);
        if (!$(this).hasClass("on")) {
            $.get("/web/loan/page/messageCode", {phone: phone},
                function (data) {
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
    });*/

    $("#btnVerify").click(function () {
        var phone = $.trim($("#phone").val());
        var realName = $.trim($("#realName").val());
        var idCard = $.trim($("#idCard").val());
        var captcha = $.trim($("#captcha").val());

        $.post("/web/loan/page/realNameSubmit", {
            phone: phone, realName: realName, idCard: idCard, captcha: captcha
        }, function (data) {
            if (data.code == "1") {
                window.location.href = "/web/index";
            }
            if (data.code == "0") {
                alert(data.message);
            }
        });

    });
});