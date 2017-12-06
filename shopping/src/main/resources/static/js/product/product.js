// function nowBuy(id) {
//     var productId  = id;
//     var count = 1;
//     $.ajax({
//         type:'post',
//         url:'/user/orders/nowBuy',
//         data:{productId:productId,count:count},
//         success:function(result){
//             if(result.code == 1)
//                 window.location.href=result.url;
//             else if(result.code == 2){
//                 window.location.href = result.url;
//             }else {
//                 alert(result.msg);
//             }
//         },error:function(){}
//     })
// }