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
});

var referrer = "";//登录后返回页面
referrer = document.referrer;
if (!referrer) {
    try {
        if (window.opener) {
            // IE下如果跨域则抛出权限异常，Safari和Chrome下window.opener.location没有任何属性
            referrer = window.opener.location.href;
        }
    } catch (e) {
    }
}

//按键盘Enter键即可登录
$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        login();
    }
});

function login() {
    var phone = $.trim($("#phone").val());
    var loginPassword = $.trim($("#loginPassword").val());
    var captcha = $.trim($("#captcha").val());

    if (phone == null || phone == "") {
        $("#phone").focus();
        return;
    }
    if (loginPassword == null || loginPassword == "") {
        $("#loginPassword").focus();
        return;
    }
    if (captcha == null || captcha == "") {
        $("#captcha").focus();
        return;
    }

    $.post("/web/loan/page/loginSubmit", {
        phone: phone,
        loginPassword: $.md5(loginPassword),
        captcha: captcha
    }, function (data) {
        if (data.code == "1") {
            window.location.href = $("#redirectUrl").val();
        }
        if (data.code == "0") {
            alert(data.message);
        }
    });
}
