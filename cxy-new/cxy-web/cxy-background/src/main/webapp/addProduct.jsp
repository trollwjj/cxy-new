<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/10 0010
  Time: 下午 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="js/uploadify/uploadifive.css">

</head>
<body>


<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title">添加商品</h4>
</div>
<div class="modal-body">

    <form class="form-horizontal">
        <div class="form-group">
            <label for="add-name" class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="add-name" name="product.name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="add-price" class="col-sm-2 control-label">商品价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="add-price" name="product.price" required>
            </div>
        </div>
        <div class="form-group">
            <label for="add-salePoint" class="col-sm-2 control-label">商品卖点</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="add-salePoint" name="product.salePoint"
                       required>
            </div>
        </div>
        <div class="form-group">
            <label for="add-file_upload" class="col-sm-2 control-label">商品图片</label>
            <div class="col-sm-10">
                <a type="file" name="file_upload" id="add-file_upload"></a>
                <input type="hidden" name="product.images" id="add-images">
                <img src="" id="add-imageId" style="width: 200px; height: 200px; display: none">
            </div>
        </div>
        <div class="form-group">
            <label for="add-categopryId" class="col-sm-2 control-label">商品类目</label>
            <div class="col-sm-10">
                <select class="form-control" id="add-categopryId" name="product.categoryId"></select>
                <input type="hidden" name="product.categoryName" id="add-categoryName">
            </div>
        </div>
        <div class="form-group">
            <label for="add-productDesc" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3" id="add-productDesc" name="productDesc"></textarea>
            </div>
        </div>
    </form>


</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
    <button type="button" class="btn btn-primary" id="btn-add-product">保存</button>
</div>



<script type="text/javascript">
    $(function () {
        <!-- 上传图片 -->
        $('#add-file_upload').uploadifive({
            'auto': true,
            'uploadScript': 'image/uploadImage',
            'fileObjName': 'file',
            'buttonText': '上传图片',
            'onUploadComplete': function (file, data) {
                $("#add-images").val(data);
                $("#add-imageId").attr("src", data).show();
            },
            'onInit': function () {
                $(".uploadifive-queue").hide();
            }
        });

        <!-- 初始化类目数据 -->
        $.post("/productCategory/list", function (data) {
            var text = "";
            for (var i = 0; i < data.length; i++) {
                text += "<option value=\"" + data[i].id + "\">" + data[i].name + "</option>";
            }
            $("#add-categopryId").html(text);
            $("#add-categoryName").val(data[0].name);
        });


        <!-- 获取选中的类目名 -->
        $("#add-categoryId").change(function () {
            var value = $("#add-categoryId option:selected").text();
            $("#add-categoryName").val(value);
        });

        <!-- 添加商品事件 -->
        $("#btn-add-product").click(function () {
            debugger
            var formValue = $("form").serialize();
            $.ajax({
                url:"/product/addProduct",
                async:true,
                data:formValue,
                type:"post",
                success:function (data) {
                    <!-- 如果是跳转到第一页 -->
//                    location.href = "/product/productList/1";
                    <!-- 如果是跳转到最后一页 -->
                    location.href = "/product/productList/${pageIndex}"
                }
            })
        })
    })
</script>

</body>
</html>
