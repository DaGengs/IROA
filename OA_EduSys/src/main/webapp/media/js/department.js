layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer, laydate = layui.laydate;

    laydate.render({
        elem: '#createtime'
    });

    table.render({
        elem: '#tbdata'
        , url: 'departmentQuery.do'
        , page: true
        , cols: [[
            {field: "dept_id", title: '部门编号', align: 'center'}
            , {field: "dept_name", title: '部门名称', align: 'center'}
            /* ,{field:'dept_p_id',  title: '上级部门', align:'center'}*/
            /* ,{field:'dept_level', title: '部门等级', align:'center'}*/
            , {field: 'createtime', title: '创建时间', align: 'center'}
            , {field: 'right', title: '操作', toolbar: "#barop", align: 'center'}
        ]]
    });

    //监听工具条
    table.on('tool(tbop)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('是否确认删除?', function (index) {
                $.ajax({
                    url: "departmentDelete.do",
                    type: "POST",
                    data: "dept_id=" + data.dept_id,
                    success: function (data) {
                        if (data.code == 1) {
                            obj.del();//删除表格中的对应行数据
                            layer.close(index);
                            layer.msg(data.msg, {icon: 6});
                        } else {
                            layer.msg(data.msg, {icon: 5});
                        }
                    }
                });
            });
        } else if (obj.event === 'edit') {//编辑 修改
            location.href = "departUpdate.html?d=" + encodeURI(JSON.stringify(data));
        }
    });

    form.on('submit(save)', function (data) {
        var department = {
            dept_id: 0,
            dept_name: $("#dept_name").val(),
            dept_p_id: $("#dept_p_id").val(),
            /*  dept_level: dept_p_id+1,*/
            createtime: $("#createtime").val(),
        };
        $.ajax({
            url: "departmentAdd.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(department),
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
//				  location.href="departList.html";
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        })
        return false;
    });

    form.on('submit(update)', function (data) {
        $.ajax({
            url: "departmentUpdate.do",
            type: "post",
            data: {
                dept_name: $("#dept_name").val(),
                dept_id: $("#dept_id").val()
            },
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
//				  location.href="departList.html";
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        })
        return false;
    });
});

$(function () {
    $.ajax({
        url: "getDepartment.do",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#dept_p_id").append("<option value='" + data[i].dept_id + "'>" + data[i].dept_name + "</option>");
            }
        }
    })
});