// 修改账户昵称
function modify(){
    var name = $('#second_name').val();
    $.ajax({
        url:'/user/modify/userName',
        type:'put',
        data:{name:name},
        success:function(result){
            if (result.code == 1){
                $('#second_name').val();
                $('#originName').html(name);
                alert("修改成功！");

            }else if(result.code == 2){
                window.location.href='/login';
            }else{
                alert(result.msg);
            }
        }
    });
}

function modifyPwd(){
    var oldPassword = $('#originPwd').val();
    var password = $('#newPwd').val();
    $.ajax({
        url:'/user/modifyPwd',
        type:'put',
        data:{oldPassword:oldPassword,password:password},
        success:function(result){
            if (result.code == 1){
                $('#second_name').val();
                $('#originName').html(name);
                alert("修改成功！");
                $('#pwdModal').modal('hide')
            }else if(result.code == 2){
                window.location.href='/login';
            }else{
                alert(result.msg);
            }
        }
    });
}


$(function () {
    // 修改账户密码
    $('#pwdForm').validator().on('submit', function (e) {
        if (e.isDefaultPrevented()) {
            // handle the invalid form...
            alert("不合理");
        } else {
            $('#pwdModal').modal('hide')
        }
    });
    // 绑定手机和邮箱
    $('#changeCall').click(function () {
        $('#callModal').modal();
    });
    // 验证手机和邮箱
    $('#changeEmail').click(function () {
        $('#codeModal').modal();
    });
    // 解绑qq/微信/微博
    $('#changeWechat').click(function () {
        $('#qqModal').modal();
    });
});

//获取短信验证码
$(document).on("click","#sendCode",function(){
    var mobile = $('#callNum').val();
    var reg = /^1[3|4|5|7|8]\d{9}$/;
    $('#callNum').parent().prev('.prompt').remove();
    $('#sms_code').parent().prev('.prompt').remove();
    if (!mobile) { $('#callNum').parent().before("<p class='prompt'>* 手机号不能为空</p>");return false; }
    if(!reg.test(mobile)){ $('#callNum').parent().before("<p class='prompt'>* 请输入正确的手机号</p>"); return false; }
    $.ajax({url:'/account/validCode/message/'+mobile,type:'get',
        success:function(result){
            if( result.code == 1 ){
                alert("发送成功！");
                 return true;
            } else {
                $('#callNum').before("<p class='prompt'>* "+result.code+"</p>"); return false;
            }
        }
    });
});

/**
 * 修改绑定的手机号码
 */
function modifyTel(){
    var validCode = $('#codeMsg').val();
    var mobile = $('#callNum').val();
    var reg = /^1[3|4|5|7|8]\d{9}$/;
    if (!mobile) { $('#callNum').parent().before("<p class='prompt'>* 手机号不能为空</p>");return false; }
    if(!reg.test(mobile)){ $('#callNum').parent().before("<p class='prompt'>* 请输入正确的手机号</p>"); return false; }
    if (!codeMsg) { $('#codeMsg').parent().before("<p class='prompt'>* 验证码不能为空</p>");return false; }
    //修改手机号码
    $.ajax({url:'/account/tel/modify/',data:{tel:mobile,validCode:validCode},type:'put',
        success:function(result){
            if( result.code == 1 ){
                alert("发送成功！");
                return true;
            } else {
                $('#callNum').before("<p class='prompt'>* "+result.code+"</p>"); return false;
            }
        }
    });
}


