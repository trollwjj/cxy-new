$(function () {
    debugger
    $.ajax({
        url:"listCategoryByPid?pid=0",
        method:"get",
        dataType:"jsonp",
        jsonpCallback:"fillData"
    })


})

/*
* <li id="cat_1" class="">
                        <h3><a href="" title="男女服装">男女服装</a></h3>
                        <div id="cat_1_menu" class="cat_menu clearfix" style="">
                            <dl class="clearfix">
                                <dt><a href="女装" href="">女装</a></dt>
                                <dd>
                                    <a href="">风衣</a>
                                </dd>
                            </dl>


                        </div>
                    </li>
* */

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
    console.log(htmlVal);
}