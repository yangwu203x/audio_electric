$(document).ready(function () {
    $('.carousels').carousels({ //人人唱app轮播
        directionNav:true,
        speed:200,
        carouselsWidth:950,
        carouselsHeight:390,
        frontWidth:223,
        frontHeight:390,
        hAlign:'center',
        vAlign:'center',
        autoplay:true,
        autoplayInterval:2000,
        shadow:true,
        pauseOnHover:false,
        reflection:false,
        reflectionHeight:0.2,
        reflectionOpacity:0.5,
        description:false,
        descriptionContainer:'.carousels_description'
    });
    change_div(6);
});

//  人人唱介绍图片轮换时文字介绍也相应变换方法
function change_div(num){
    document.getElementById("sliderText"+(num-1)).style.display="none";
    if(num==6){
        num=1;
    }
    document.getElementById("sliderText"+num).style.display="block";
    num++;
    setTimeout("change_div("+num+")",2000);//2秒切换一次
}