<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-tip',
        text: "课程详情",
        handler: function () {
           var row = $("#lessons").treegrid("getSelected");
           if(row == null ){
                alert("请选中行！！！！");
           }else{
               if(row.count == null){  //选中的是课程
                   $("#lessons_dialog").dialog("open");
                   /*填充内容*/
                   $("#lessons_ff").form("load",row);

               }else {
                   alert("请先选择课程！！！");
               }
           }

        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加课程",
        handler: function () {
            $("#lessons_addg").dialog("open");
        }
    }]

    $(function () {
        $("#lessons").treegrid({
            url: "${pageContext.request.contextPath}/lessons/findAll",
            idField: 'id',
            treeField: 'name',
            columns: [[
                {field:'name',title:'名称',width:50,align:'left'},
                {field:'count',title:'计数次数',width:50,align:'center'},
                {field:'date',title:'上传时间',width:50,align:'center'},
              //  {field:'status',title:'状态',width:50,align:'center'},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [2, 5, 10, 20],
            pageSize: 2,
            toolbar: toolbar,
            checkbox:true,


        })

    })


    function submit() {
        $('#lessons_add').form('submit', {
            url: "${pageContext.request.contextPath}/lessons/add",

        })
    }

</script>


<table id="lessons"></table>
<%--专辑详情--%>
<div id="lessons_dialog" class="easyui-dialog" title="专辑详情" style="width:600px;height:750px;"
     data-options="iconCls:'icon-tip',resizable:true,modal:true,closed:true">

    <form id="lessons_ff" method="post">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="title">课程名称:</label>
            <input id="title" name="name" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="acount">课程级别:</label>
            <input id="acount" name="score" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="publishDate">修改日期:</label>
            <input id="publishDate" name="date" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="status">状态:</label>
            <input id="status" name="status" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

    </form>

</div>




<%--添加专辑--%>
<div id="lessons_addg" class="easyui-dialog" title="添加专辑" style="width:400px;height:650px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                    $('#lessons_add').form('submit', {
                     url:'${pageContext.request.contextPath}/lessons/add',
                    success:function(data){
                         $('#lessons_addg').dialog('close');
                         $('#lessons').treegrid('reload')

                    }


                 })
				}
			},{
				text:'关闭',
				handler:function(){
				$('#lessons_addg').dialog('close');
				}
			}]">

    <form id="lessons_add" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="name"  required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'课程名称'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="score" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'课程级别'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input type="text" name="date"  class="easyui-datebox" data-options="iconCls:'icon-man',prompt:'修改日期'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
                <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;text-align: center;">
                    <span style="line-height: 40px;display: block;font-size: 14px">状&nbsp;&nbsp;态:</span>
                </span>
            <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;float: right">
                    <input class="easyui-switchbutton" name="status" data-options="onText:'true',offText:'false',handleWidth:50,handleText:'状态'" style="width:100%;height: 100%">
                </span>
        </div>
    </form>

</div>




