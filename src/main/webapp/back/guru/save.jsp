<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            上传图片:<input type="text" name="bannerFileName" class="easyui-filebox" data-options="buttonText:'选择图片',validType:'image'"><br>
        </div>
        <div style="margin-top: 70px;">
            上师姓名:<input type="text" name="name" class="easyui-textbox"><br>
        </div>
        <div style="margin-top: 20px;">
            上师性别: <input type="text" name="sex" class="easyui-textbox" >
        </div>

    </form>
</div>