<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>
<div style="text-align: center;">
    <form id="editDeptInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.admin.id}">
        <div style="margin-top: 70px;">
            原密码: <input type="text" name="password" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            新密码: <input type="text" name="newPassword"  class="easyui-textbox" >
        </div>
    </form>
</div>