var countTimes = Number($("#countTime").attr("title"));
var endtime= new Date(countTimes);//结束时间
function FreshTime()  {
    var nowtime = new Date();//当前时间
    var lefttime= parseInt((endtime.getTime()-nowtime.getTime())/1000);
    if(lefttime >0){
        var h=parseInt((lefttime/3600)%24);
        var m=parseInt((lefttime/60)%60);
        var s=parseInt(lefttime%60);
        $('#countTime').html(h+"小时"+m+"分"+s+"秒")
    }else if(lefttime == 0){
        window.location.reload();
    }else{
        clearInterval(sh);
    }
}

FreshTime();
var sh;
sh=setInterval(FreshTime,1000);