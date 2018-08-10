layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer, laydate = layui.laydate;

    laydate.render({
        elem: '#startTime'
    });

    table.render({
        elem: '#tbdata'
        , url: 'classesQuery.do'
        , page: true
        , cols: [[
            {field: "no", title: '序号', align: 'center', type: 'numbers', sort: true}
            , {field: "class_no", title: '班级编号', align: 'center', sort: true}
            , {field: 'class_name', title: '班级名称', align: 'center'}
            , {field: 'subj_id', title: '所属学科', align: 'center', templet: '<div>{{d.subject.subj_name}}</div>'}
            , {field: 'count', title: '班级人数', align: 'center', sort: true}
            , {field: 'class_week', title: '班级周期', align: 'center', sort: true}
            , {field: 'startTime', title: '开班日期', align: 'center', sort: true}
            , {field: 'right', title: '操作', toolbar: "#barop", align: 'center'}
        ]]
    });

    //监听工具条
    table.on('tool(tbop)', function (obj) {
        var data = obj.data;
        console.log(data);
        if (obj.event === 'del') {
            layer.confirm('是否确认删除?', function (index) {
                $.ajax({
                    url: "classesDelete.do",
                    type: "POST",
                    data: "no=" + data.class_no,
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
            location.href = "classUpdate.html?d=" + encodeURI(JSON.stringify(data));
        }
    });

    form.on('submit(save)', function (data) {
        var classes = {
            class_id: 0,
            class_name: $("#class_name").val(),
            subj_id: $("#subj_id option:selected").val(),
            startTime: $("#startTime").val(),
            class_week: $("#class_week").val()
        };
        $.ajax({
            url: "classesAdd.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(classes),
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
                    location.href = "classList.html";
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        })
        return false;
    });

    form.on('submit(update)', function (data) {
        var classes = {
            class_id: 0,
            class_no: $("#class_no").val(),
            class_name: $("#class_name").val(),
            subj_id: $("#subj_id").val(),
            startTime: $("#startTime").val(),
            class_week: $("#class_week").val()
        };
        $.ajax({
            url: "classesUpdate.do",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(classes),
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg, {icon: 6});
                    location.href = "classList.html";
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
        url: "getSubject.do",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#subj_id").append("<option value='" + data[i].subj_id + "'>" + data[i].subj_name + "</option>");
            }
        }
    });
})