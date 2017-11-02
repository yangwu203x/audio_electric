
$(function () {

    // 国际区号选择和验证电话号码
    var telInput = $("#mobile-number"),
        errorMsg = $("#error-msg");
    // 初始化
    telInput.intlTelInput({
        nationalMode: true,
        initialCountry: "cn"
    });
    var reset = function() {
        telInput.removeClass("error");
        errorMsg.addClass("hide");
    };
    //  验证号码是否符合规范
    telInput.blur(function() {
        reset();
        if ($.trim(telInput.val())) {
            if (!telInput.intlTelInput("isValidNumber")) {
                telInput.addClass("error");
                errorMsg.removeClass("hide");
            }
        }
    });
    // on keyup / change flag: reset
    telInput.on("keyup change", reset);
});

// 初始化验证
$('#regEmail_form').validator();
$('#regPhone_form').validator();
$('#login_form').validator();
$('#pwd_form').validator();
// 登录
function showLogin() {
    $('#login_form').show();
    $('#regEmail_form').hide();
    $('#regPhone_form').hide();
}
// 邮箱注册
function showRegEmail() {
    $('#login_form').hide();
    $('#regEmail_form').show();
    $('#regPhone_form').hide();
}




