
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