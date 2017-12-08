var addModals = $('#addModal');

/**
 * 发票和优惠券-start
 */
$('.js_deleteDiscount').click(function () {
    $(this).parent().remove();
});
//点击在线支付，出现提示，点击货到付款，提示消失
$('#payWay li').click(function () {
    $(this).find('input').attr('checked','checked');
    $(this).siblings().find('input').attr('checked',false);
});
$('#payWay li:first-child').click(function () {
    $('#paywayAli').show();
});
$('#payWay li:nth-child(2)').click(function () {
    $('#paywayAli').hide();
});
//点击公司发票，出现纳税人识别号，点击个人发票，纳税人识别号消失
$('#invoice li:first-child').click(function () {
    $('#companyTip').hide();
    $('#personTip').show();
});
$('#invoice li:nth-child(2)').click(function () {
    $('#personTip').hide();
    $('#companyTip').show();
});
/**
 * 发票和优惠券-end
 */

$('.delete_tip').click(function (e) {
    e.stopPropagation();
    var element = $(this).parents('.col-md-4');
    var addressId = element.find('input').val();
    Common.confirm({
        nameId: "#deleteModal",
        btnId: "#common_confirm_btn",
        operate: function (reselt) {
            if (reselt) {
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

$(function () {
    // 收货地址点击删除效果

    // 收货地址点击'设为默认地址'效果
    $('.change_tip').click(function () {
        $('.change_tip').not(this).text("【设为默认地址】");
        $(this).text("【默认地址】");
        $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
        var addressId = $(this).parent().parent().find('input').val();
        var url = '/user/address/defaultAddress/modify/id/'+addressId;
        var data = {};
        var method = "put";
        formSubmit(url,data,method,function(result){
            var address = result.data;
            $('#addressId').val(address.id);
            $('#recipients').html(address.name);
            $('#detailPosition').html(address.absoluteAddress);
            $('#tel').html(address.tel);});
    });
    // 点击添加新地址弹窗

    $("#select-area").selectAddress();//初始化省市区联动select

    $('#select-area').on('change',function () {
        $("#provinceVal").val($("#province option:selected").text());
        $("#cityVal").val($("#city option:selected").text());
        $("#areaVal").val($("#area option:selected").text());
    });

});

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

/*
*提交地址
* */
function addAddress(){
    var ajaxUrl = $("#addAddress_form").attr("action");
    var method = $("#addAddress_form").attr("method");
    var param = $("#addAddress_form").serialize();
    formSubmit(ajaxUrl,param,method,function(result){location.reload();})
}

function add(){
    addModals.modal();
    $("#addAddress_form")[0].reset(); //表单弹出前初始化表单
    $('#addressId').val("");
    $('#addAddress_form').attr("action",'/user/address/add');
    $('#addModalLabel').html("添加新地址");
    $('#province').find("option[value=0]").attr("selected",true);
    $('#city').find("option[value=0]").attr("selected",true);
    $('#area').find("option[value=0]").attr("selected",true);
    $('#addAddress_form').attr('method',"post");
}
function edit(addressId){
    $('#addAddress_form').attr("action",'/user/address/modify');
    $('#addModalLabel').html("编辑地址");
    addModals.modal();
    formSubmit('/user/address/view/id/'+addressId,{},'get',function(result){
        var address = result.data;
        var provinceCode = address.provinceId;
        var cityCode = address.cityId;
        var areaCode = address.areaId;
        $('#addressId').val(address.id);
        $('#inputUser').val(address.name);
        $('#inputPhone').val(address.tel);
        $('#inputAddDetail').val(address.absoluteAddress);
        writePlace(provinceCode,cityCode,areaCode);
    })
    $('#addAddress_form').attr('method',"put");
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

$('.addMenu').click(function () {
    $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
    var addressId = $(this).parent().find('input').val();
    formSubmit('/user/address/temporaryAddress/set/id/'+addressId,{},'get',function(result){
        var address = result.data;
        $('#addressId').val(address.id);
        $('#recipients').html(address.name);
        $('#detailPosition').html(address.absoluteAddress);
        $('#tel').html(address.tel);
    })
});


function sumbitOrder(){
    var addressId = $('#addressId').val();
    var trolleyIds = $('#trolleyIds').val();
    //var 发票
    var invoiceHeader;//抬头
    //纳税人识别号
    var TaxIdent;
    var invoice = $("input[name=invoice]:checked").val();

    if(invoice == 'person'){
        //个人发票
        invoiceHeader = $('#personal').val();
    }else if(invoice == 'company'){
        //公司发票
        invoiceHeader = $('#companyTitle').val();
        TaxIdent = $('#company').val();
    }
    $.ajax({type:'post',url:'/user/orders/generate/three',data:{addressId:addressId,trolleyIds:trolleyIds,invoice:invoice,invoiceHeader:invoiceHeader,TaxIdent:TaxIdent},
        success:function(result){
            if (result.code == 1){
                var orders = result.data;
                window.location.href = '/user/orders/onlinePay/view/'+orders.orderNum;
            }else if(result.code == 2){
                window.location.href='/login';
            }else{
                alert(result.msg);
            }
        }
    });
}
$(function () {
    // 收货地址点击'设为默认地址'效果
    $('.change_tip').click(function (e) {
        $('.change_tip').not(this).text("【设为默认地址】");
        $(this).text("【默认地址】");
        $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
        var addressId = $(this).parent().parent().find('input').val();
        formSubmit('/user/address/defaultAddress/modify/id/'+addressId,{},'put',function(result){
            var address = result.data;
            $('#addressId').val(address.id);
            $('#recipients').html(address.name);
            $('#detailPosition').html(address.absoluteAddress);
            $('#tel').html(address.tel);
        })
    });
    // 点击添加新地址弹窗
    $('#addModal').on('show.bs.modal', function() {
        $("#select-area").selectAddress();
    })
});