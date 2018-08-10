layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer, laydate = layui.laydate;

    laydate.render({
        elem: '#createtime'
    });

    table.render({
        elem: '#tbdata'
        , url: 'subjectQuery.do'
        , page: true
        , cols: [[
            {field: "subj_id", title: '学科编号', align: 'center'}
            , {field: "subj_name", title: '学科名称', align: 'center'}
            , {field: 'subj_week', title: '学科周期', align: 'center'}
            , {field: 'subj_type', title: '学科类型', align: 'center'}
            , {field: 'createtime', title: '成立日期', align: 'center'}
            , {field: 'right', title: '操作', toolbar: "#barop", align: 'center'}
        ]]
    });

    //监听工具条
    table.on('tool(tbop)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('是否确认删除?', function (index) {
                $.ajax({
                    url: "subjectDelete.do",
                    type: "POST",
                    data: "subj_id=" + data.subj_id,
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
            location.href = "subjectUpdate.html?d=" + encodeURI(JSON.stringify(data));
        }
    });

    form.on('submit(save)', function (data) {
        var subject = {
            subj_id: 0,
            subj_name: $("#subj_name").val(),
            subj_week: $("#subj_week").val(),
            subj_type: $("#subj_type option:selected").val(),
            createtime: $("#createtime").val(),
        };
        $.ajax({
            url: "subjectAdd.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(subject),
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
                    location.href = "subjectList.html";
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        })
        return false;
    });

    form.on('submit(update)', function (data) {

        var subject = {
            subj_id: $("#subj_id").val(),
            subj_name: $("#subj_name").val(),
            subj_week: $("#subj_week").val(),
            subj_type: $("#subj_type option:selected").val(),
            createtime: $("#createtime").val(),
        };

        $.ajax({
            url: "subjectUpdate.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(subject),
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
                    location.href = "subjectList.html";
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        })
        return false;
    });

});
