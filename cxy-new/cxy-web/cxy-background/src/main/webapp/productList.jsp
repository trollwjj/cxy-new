
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/11 0011
  Time: 下午 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">


</head>
<body>
<div class="row">
    <div class="col-md-offset-8">
        <button class="btn btn-primary" id="btn-add-show-model">添加</button>
        <button class="btn btn-danger" id="btn-delete-all">删除</button>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <table class="table table-bordered table-hover ">
            <thead>
            <tr>
                <td>
                    <input type="checkbox" id="checkbox-all">
                </td>
                <td>ID</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>商品图片</td>
                <td>商品卖点</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${pageInfo.list}" var="product">
                <tr>
                    <td>
                        <input type="checkbox" value="${product.id}" class="checkbox-delete">
                    </td>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>
                        <img src="${product.images}" style="width: 100px; height: 100px">
                    </td>
                    <td>${product.salePoint}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-xs btn-update" btn-id="${product.id}"
                                data-toggle="modal" data-target="#update-modal">修改
                        </button>
                        <button type="button" class="btn btn-danger btn-xs btn-delete" btn-id="${product.id}">删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<!-- 分页 -->
<div class="row">
    <div class="col-md-6">
        &nbsp;&nbsp;&nbsp;&nbsp;总共${pageInfo.total}条,总共${pageInfo.pages}页,当前第${pageInfo.pageNum}页
    </div>
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="/product/productList/1">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="/product/productList/${pageInfo.prePage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums}" var="num">

                    <c:choose>
                        <c:when test="${pageInfo.pageNum == num}">
                            <li class="active"><a href="/product/productList/${num}">${num}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/product/productList/${num}">${num}</a></li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="/product/productList/${pageInfo.nextPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a href="/product/productList/${pageInfo.pages}">
                        <span aria-hidden="true">尾页</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<div class="modal fade" id="add-model" tabindex="-1" role="dialog" aria-labelledby="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<div class="modal fade" id="update-model" tabindex="-1" role="dialog" aria-labelledby="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>



<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/uploadify/jquery.uploadifive.min.js"></script>
<script type="text/javascript">
    $(function () {

        $("#btn-add-show-model").click(function () {

            $("#add-model").modal({
                backdrop: "static",
                keyboard: false,
                remote:"/product/showAddProduct?pageIndex=${pageInfo.pages+1}"
            });
        })

        <!-- 添加修改商品事件 -->
        $(".btn-update").click(function () {
            var productId = $(this).attr("btn-id");
            $("#update-model").modal({
                backdrop:"static",
                keyboard:false,
                remote:"/product/showUpdateProduct?pageIndex=${pageInfo.pageNum}&productId="+productId
            });
        })

        <!-- 单个删除 -->
        $(".btn-delete").click(function () {
            var productId = $(this).attr("btn-id");
            var confirmVal = confirm("确认删除该商品?");
            if (confirmVal == true){
                $.ajax({
                    url:"product/deleteProduct/"+productId,
                    async: true,
                    method:"post",
                    success:function (data) {
                        if (data == "true") {
                            location.href = "product/productList/1";
                        }
                    }
                })
            }
        })

        <!-- 单选框事件 -->
        $("#checkbox-all").change(function () {
            $(".checkbox-delete").prop("checked",$("#checkbox-all").prop("checked"));
        })

        $(".checkbox-delete").change(function () {
            $("#checkbox-all").prop("checked", $(".checkbox-delete").length == $(".checkbox-delete:checked").length);
        })

        <!--多个删除-->
        $("#btn-delete-all").click(function () {

            var input_checkboxex = $(".checkbox-delete:checked");
            var ids = new Array();
            for (var i=0;i<input_checkboxex.length; i++){
                ids.push($(input_checkboxex[i]).val());
            }
            var obj = new Object();
            obj.ids = ids;

            $.post("product/deleteProducts",obj, function (data) {

                if (data == "true"){
                    location.href = "product/productList/1";
                }
            })
        })
    })
</script>
</body>
</html>
