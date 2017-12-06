function addSubmit(){
    var url = $("#addAddress_form").attr("action");
    var method = $("#addAddress_form").attr("method");
    var data = $("#addAddress_form").serialize();
    $.ajax( {url:url, data:data, success:function(result){
        if(result.code == 1)
            window.location.reload();
        else if(result.code == 2){
            window.location.href = result.url;
        }else{
            alert(result.msg);
        }
    }, type:method});
}
var addModals = $('#addModal');
var provinceVal = $('#provinceVal');
var cityVal = $('#cityVal');
var areaVal = $('#areaVal');
$(function () {
    // 收货地址点击删除效果
    $('.delete_tip').click(function (e) {
        e.stopPropagation();
        var element = $(this).parents('.col-md-4');
        Common.confirm({
            nameId:"#deleteModal",
            btnId:"#common_confirm_btn",
            operate: function (reselt) {
                if (reselt) {
                    var addressId = element.find('input').val();
                    $.ajax({
                        type:"DELETE",
                        url:'/user/address/delete/id/'+addressId,
                        success:function(result){
                            if (result.code == 1){
                                element.remove();
                            }else if(result.code == 2){
                                window.location.href='/login';
                            }else{
                                alert(result.msg);
                            }
                        }
                    });
                }
            }
        });
    });
    // 收货地址点击'设为默认地址'效果
    $('.change_tip').click(function () {
        $('.change_tip').not(this).text("【设为默认地址】");
        $(this).text("【默认地址】");
        $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
        var addressId = $(this).parent().parent().find('input').val();
        $.ajax({url:'/user/address/defaultAddress/modify/id/'+addressId,type:'put',
            success:function(result){
                if (result.code == 1){
                }else if(result.code == 2){
                    window.location.href=result.url;
                }else{
                    alert(result.msg);
                }
            }
        });
    });
    // 点击添加新地址弹窗

    $("#select-area").selectAddress();//初始化省市区联动select

    $('#select-area').on('change',function () {
        provinceVal.val($("#province option:selected").text());
        cityVal.val($("#city option:selected").text());
        areaVal.val($("#area option:selected").text());
    });

});

function add(){
    addModals.modal();
    $("#addAddress_form")[0].reset(); //表单弹出前初始化表单
    $('#addAddress_form').attr("action",'/user/address/add');
    $('#addModalLabel').html("添加新地址");
    $('#province').find("option[value=0]").attr("selected",true);
    $('#city').find("option[value=0]").attr("selected",true);
    $('#area').find("option[value=0]").attr("selected",true);
    $('#addressId').val('');
    $("#addAddress_form").attr('method',"post");
}


function edit(addressId){
    $('#addAddress_form').attr("action",'/user/address/modify');
    $('#addModalLabel').html("编辑地址");
    addModals.modal();
    $.ajax({
        type:"get",
        url:'/user/address/view/id/'+addressId,
        success:function(result){
            if (result.code == 1){
                var address = result.data;
                var provinceCode = address.provinceId;
                var cityCode = address.cityId;
                var areaCode = address.areaId;
                $('#addressId').val(address.id);
                $('#inputUser').val(address.name);
                $('#inputPhone').val(address.tel);
                $('#inputAddDetail').val(address.detailPosition);
                if (address.selected == '1'){
                    $('#choose1').attr('checked',true);
                } else{
                    $('#choose1').attr('checked',false);
                }
                writePlace(provinceCode,cityCode,areaCode);
            }else if(result.code == 2){
                window.location.href=result.url;
            }else{
                alert(result.msg);
            }
        }
    });
    $("#addAddress_form").attr('method',"put")
}



/**
 * 渲染地址
 * @param provinceCode
 * @param cityCode
 * @param areaCode
 */
function writePlace(provinceCode,cityCode,areaCode){
    var provinceOption = "province[postcode=" + provinceCode + "]";
    var cityOption = provinceOption + " " + "city[postcode=" + cityCode + "]"
    var city = $('#city');
    var area = $('#area');
    var province = $('#province');
    province.find("option[value='" + provinceCode + "']").attr("selected",true);
    $.ajax({
        url:"/extands/areas/areas.xml",datatype:"xml",type:"GET",
        success:function(xmlDoc){
            var cityList = $(xmlDoc).find(provinceOption).children(city);
            $(cityList).each(function(){
                city.append("<option value='"+$(this).attr("postcode")+"'>"+$(this).attr("name")+"</option>");
            });
            city.find("option[value='" + cityCode + "']").attr("selected",true);
            var areaList = $(xmlDoc).find(cityOption).children(area);
            $(areaList).each(function(){
                area.append("<option value='"+$(this).attr("postcode")+"'>"+$(this).attr("name")+"</option>");
            });
            area.find("option[value='" + areaCode + "']").attr("selected",true);
            $('#provinceVal').val($("#province option:selected").text());
            $('#cityVal').val($("#city option:selected").text());
            $('#areaVal').val($("#area option:selected").text());
        }
    });
}
function formSubmit(url,data,method,callback){
    $.ajax({url:url,type:method,data:data,
        success:function(result){
            if (result.code == 1){
                callback(result);
            }else if(result.code == 2){
                window.location.href=result.url;
            }else{
                alert(result.msg);
            }
        }
    });
}

$('.addMenu').click(function () {
    $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
    var addressId = $(this).parent().find('input').val();
    formSubmit('/user/address/temporaryAddress/set/id/'+addressId,{},'get',function(result){
    })
});



