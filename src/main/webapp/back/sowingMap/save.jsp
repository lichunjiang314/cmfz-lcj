<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveMapInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            上传图片:<input type="text" name="bannerFileName" class="easyui-filebox" data-options="buttonText:'选择图片',validType:'image'"><br>
        </div>
        <div style="margin-top: 70px;">
            图片标题:<input type="text" name="title" class="easyui-textbox"><br>
        </div>
        <div style="margin-top: 20px;">
            图片描述: <input type="text" name="description" class="easyui-textbox" >
        </div>

    </form>
</div>