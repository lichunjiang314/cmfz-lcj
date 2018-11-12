<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function () {

            //通过js创建datagrid
            $("#dg").datagrid({
                url:'${pageContext.request.contextPath}/sowingMap/findAll',//用来请求远程数据
                pagination:true,//显示分页工具栏
                pageNumber:1,//当前页
                pageSize:2,//每页显示记录数
                pageList:[2,5,10,15,30,500],
                striped:true,
                rownumbers:true,
                singleSelect:false,
                ctrlSelect:true,
                //checkOnSelect:false,
                //selectOnCheck:false,
                queryParams:{
                    name:"xiaohei",
                },
                remoteSort:false,
                multiSort:true,
                columns:[[
                    {title:'cks',field:"cks",checkbox:true},
                    {title:'图片id',field:'id',width:120,},
                    {title:'图片标题',field:'title',width:120,},
                    {title:'图片状态',field:'status',width:120,},
                    {title:'上传日期',field:'date',width:120,sortable:true},
                    {title:'图片描述',field:'description',width:120,},
                    {title:'操作',field:'options',width:200,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-pencil',plain:true\">删除</a>&nbsp;&nbsp;" +
                                "<a href='javascript:;' class='options' onclick=\"openEditMapDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                        }
                    }
                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#gb',
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgPath + '" style="height:80px;"></td>' +
                        '<td style="border:0">' +
                        '<p>imgPath: ' + rowData.date + '</p>' +
                        '<p>imgPath: ' + rowData.imgPath + '</p>' +
                        '<p>Status: ' + rowData.status + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });


        });


        //打开修改用户的对话框
        function openEditMapDialog(id){
            $("#editMapDialog").dialog({
                href:'${pageContext.request.contextPath}/back/sowingMap/edit.jsp?id='+id,
                buttons:[
                    {
                        iconCls:'icon-save',
                        text:"修改",
                        handler:function(){
                            $("#editMapInputForm").form('submit',{
                                url:"${pageContext.request.contextPath}/sowingMap/motify",
                                success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                    //关闭dialog
                                    $("#editMapDialog").dialog('close');
                                    //刷新datagrid
                                    $("#dg").datagrid('reload');//刷新当前datagrid
                                    //提示修改信息
                                    $.messager.show({title:'提示',msg:"用户信息修改成功!!!"});
                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:"取消",
                        handler:function(){
                            $("#editMapDialog").dialog('close');
                        }
                    },
                ]
            });

        }

        //删除一行的事件
        function delRow(id){
            //获取当前点击id发送ajax请求删除id这个选中项的信息
            $.post("${pageContext.request.contextPath}/sowingMap/remove",{"id":id},function (result) {//响应成功之后回调
                //刷新datagrid数据
                $("#dg").datagrid('reload');//刷新当前datagrid
            });
        }

        //打开保存用户对话框函数
        function openSaveMapDialog(){
            $("#saveMapDialog").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存用户信息
                        $("#saveMapInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/sowingMap/upload',
                            success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                                var resultObj = $.parseJSON(result);
                                if(resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:resultObj.message});
                                }
                                //关闭对话框
                                $("#saveMapDialog").dialog('close');
                                //刷新datagrid
                                $("#dg").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#saveMapDialog").dialog('close');
                    }
                }]
            });
        }
        //批量删除多行
        function delMapRows(){
            var rows = $("#dg").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:"至少选中一行!!!"});
            }else{
                var ids = [];
                for (var i = 0; i < rows.length ; i++) {
                    console.log(rows[i].id);
                    ids.push(rows[i].id);
                }
                console.log(ids);
                //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
                //                        如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
                $.ajax({
                    url:"${pageContext.request.contextPath}/sowingMap/remove",
                    type:"POST",
                    traditional:true,//传递数据类型的数据时必须设置这个属性为true
                    data:{id:ids},
                    success:function(result){
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功!!!"});
                        //刷新datagrid
                        $("#dg").datagrid('reload');
                    },
                    error:function(){
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败!!!"});
                        //刷新datagrid
                        $("#dg").datagrid('reload');
                    }
                })
            }
        }
    </script>




<%--datagrid数据表格--%>
<table id="dg"></table>

<%--datagrid工具栏--%>
<div id="gb">
    <a href="#" class="easyui-linkbutton" onclick="openSaveMapDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="delMapRows();" data-options="iconCls:'icon-pencil',plain:true">批量删除</a>
</div>

<%--保存用户对话框--%>
<div id="saveMapDialog" data-options="href:'${pageContext.request.contextPath}/back/sowingMap/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存用户信息'">



</div>

<%--更新用户对话框--%>
<div id="editMapDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改用户信息'">



</div>



