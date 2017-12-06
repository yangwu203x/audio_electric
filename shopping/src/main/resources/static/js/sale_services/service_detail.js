$(function() {
    var objUrl;
    var img_html;
    $("#myFile").change(function() {
        var img_div = $(".img_div");
        var filepath = $("input[name='myFile']").val();
        for(var i = 0; i < this.files.length; i++) {
            objUrl = getObjectURL(this.files[i]);
            var extStart = filepath.lastIndexOf(".");
            var ext = filepath.substring(extStart, filepath.length).toUpperCase();
            /*鉴定每个图片上传尾椎限制 */
            if(ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
                $(".shade").fadeIn(500);
                $(".text_span").text("图片限于bmp,png,gif,jpeg,jpg格式");
                this.value = "";
                $(".img_div").html("");
                return false;
            } else{
                /*
                 若规则全部通过则在此提交url到后台数据库
                 * */
                img_html = "<div class='isImg'><img src='" + objUrl + "' style='height: 100%; width: 100%;' /><button class='removeBtn' onclick='javascript:removeImg(this)'>x</button></div>";
                img_div.append(img_html);
            }

        }
        /*鉴定每个图片大小总和*/
        var file_size = 0;
        var all_size = 0;
        for(var j = 0; j < this.files.length; j++) {
            file_size = this.files[j].size;
            all_size = all_size + this.files[j].size;
            var size = all_size / 1024;
            if(size > 500) {
                $(".shade").fadeIn(500);
                $(".text_span").text("上传的图片大小不能超过100k！");
                this.value = "";
                $(".img_div").html("");
                return false;
            }
        }
        return true;
    });
    /*鉴定每个浏览器上传图片url 目前没有合并到Ie*/
    function getObjectURL(file) {
        var url = null;
        if(window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if(window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if(window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        //console.log(url);
        return url;
    }



    $("#select-area").selectAddress();
    // 点击添加新地址弹窗
    $('#addModal').on('show.bs.modal', function() {
        var provinceId = $('#provinceId1').val();
        var cityId = $('#cityId1').val();
        var areaId = $('#areaId1').val();

        writePlace(provinceId,cityId,areaId);
    });

    //  点击更换退回方式---上门取件
    $('#changeWay1').click(function () {
        $('#delivery_self').css('display','block');
        $('#delivery_door').css('display','none');
        $('.address_t').html('退货地址');
        $('#js_edit').css('display','none');
    });
    //  点击更换退回方式---自找快递
    $('#changeWay2').click(function () {
        $('#delivery_self').css('display','none');
        $('#delivery_door').css('display','block');
        $('.address_t').html('取件地址');
        $('#js_edit').css('display','inline');
    });
});
/*上传图片附带删除 再次地方可以加上一个ajax进行提交到后台进行删除 */
function removeImg(r){
    $(r).parent().remove();
}

function complete(){
    var inputUser = $('#inputUser').val();
    var inputTel = $('#inputPhone').val();
    var province = $("#province option:selected").text();
    var provinceId = $("#province option:selected").val();
    var city = $("#city option:selected").text();
    var cityId = $("#city option:selected").val();
    var area = $("#area option:selected").text();
    var areaId = $("#area option:selected").val();
    $('#receiver1').text(inputUser);
    $('#tel1').text(inputTel);
    $('#detailAddress1').text(province+city+area);
    $('#provinceId1').val(provinceId);
    $('#cityId1').val(cityId);
    $('#areaId1').val(areaId);
}

laydate.render({
    elem: '#date', //指定元素
    theme:'#ff5400',
    value: new Date(),
    showWeeks: true
});

function cancerSaleService(id){
    $.ajax({url:'/user/service/cancer',data:{id:id},type:'put',success:function(result){
        if (result.code == 1){
            alert("取消成功！");
            window.location.reload();
        }else if(result.code == 2){
            window.location.href = result.url;
        }else{
            alert(result.msg);
        }
    }})
}