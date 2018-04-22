$(function () {
    debugger
    $.ajax({
        url:"listCategoryByPid?pid=0",
        method:"get",
        dataType:"jsonp",
        jsonpCallback:"fillData"
    })


})


function fillData(data) {
    var htmlVal = "";
    for (var i=0; i<data.length; i++){
        htmlVal += "<li id=\"cat_"+(i+1)+"\" >";
        var firstObj = data[i];
        htmlVal += "<h3><a href=\"\" title=\""+firstObj.name+"\">"+firstObj.name+"</a></h3>";


        if(firstObj.children != null){
            if (firstObj.children.length > 0){
                htmlVal += "<div id=\"cat_1_menu\" class=\"cat_menu clearfix\" style=\"\">";
                for (var j=0; j<firstObj.children.length; j++){
                    var secondObj = firstObj.children[j];
                    htmlVal += "<dl class=\"clearfix\">";
                    htmlVal += "<dt><a href=\""+secondObj.name+"\" href=\"\">"+secondObj.name+"</a></dt>";

                    if(secondObj.children != null){
                        if (secondObj.children.length > 0){
                            htmlVal += "<dd>";
                            for(var k=0;k<secondObj.children.length; k++) {
                                var thirdObj = secondObj.children[k];
                                htmlVal += "<a href=\"\">" + thirdObj.name +" </a>";
                            }
                            htmlVal += "</dd>";
                        }
                    }
                    htmlVal += "</dl>";
                }
                htmlVal += "</div>";
            }
        }

        htmlVal += "</li>"


    }
    $("#cat-ul").html(htmlVal);

    jQuery("#shop_hd_menu_all_category").hover(function(){
        jQuery(this).addClass('shop_hd_menu_hover');
    },function(){
        jQuery(this).removeClass('shop_hd_menu_hover');
    });

    jQuery(".shop_hd_menu_all_category_hd_menu li").hover(function(){
        jQuery(this).addClass('hover');
    },function(){
        jQuery(this).removeClass('hover');
    });
}