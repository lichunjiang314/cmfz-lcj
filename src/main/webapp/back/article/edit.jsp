<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editArtInputForm").form('load','${pageContext.request.contextPath}/article/findOne?id=${param.id}'); //{"id":"21","name":"小黑"}
    })
</script>
<div style="text-align: center;">
    <form id="editArtInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            文章标题: <input type="text" name="name" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            图片路径: <input type="text" name="img"  class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            文章内容: <input type="text" name="content" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            上传时间: <input type="text" name="date"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            文章作者: <input type="text" name="author" class="easyui-textbox" >
        </div>
    </form>
</div>