<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editMapInputForm").form('load','${pageContext.request.contextPath}/sowingMap/findOne?id=${param.id}'); //{"id":"21","name":"小黑"}
    })
</script>
<div style="text-align: center;">
    <form id="editMapInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            图片标题: <input type="text" name="title" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            图片路径: <input type="text" name="imgPath"  class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            图片状态: <input type="text" name="status" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            上传时间: <input type="text" name="date"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            图片状态: <input type="text" name="description" class="easyui-textbox" >
        </div>
    </form>
</div>