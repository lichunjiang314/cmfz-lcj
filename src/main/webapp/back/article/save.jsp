<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="saveArtInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            上传图片:<input type="text" name="bannerFileName" class="easyui-filebox" data-options="buttonText:'选择图片',validType:'image'"><br>
        </div>
        <div style="margin-top: 70px;">
            文章标题:<input type="text" name="name" class="easyui-textbox"><br>
        </div>
        <div style="margin-top: 20px;">
            文章内容: <input type="text" name="content" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            文章作者: <input type="text" name="author" class="easyui-textbox" >
        </div>
        <div style="margin-top: 20px;">
            修改日期：<input type="text" name="date"  class="easyui-datebox" >
        </div>
    </form>
</div>