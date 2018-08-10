var obj;

layui.use(['table', 'form'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer;

    table.render({
        elem: '#tbdata'
        , url: 'getWeekly.do?stu_name=' + obj.stu_name
        , page: true
        , cols: [[
            {field: "stu_name", width: '10%', title: '姓名', align: 'center'}
            , {field: 'week_title', width: '20%', title: '周报标题', align: 'center'}
            , {field: 'week_content', width: '45%', title: '周报内容', align: 'center'}
            , {field: 'status', width: '10%', title: '周报状态', align: 'center'}
            , {field: 'createtime', width: '15%', title: '创建时间', align: 'center'}
        ]]
    });

    form.on('submit(demo1)', function (data) {
        console.log(JSON.stringify(data.field));
        $.ajax({
            url: "saveWeekly.do",
            type: "post",
            data: {
                stu_name: $("#stu_name").val(),
                week_title: $("#week_title").val(),
                week_content: $("#week_content").val()
            },
            success: function (data) {
                if (data == 1) {
                    layer.msg("提交成功");
                    window.location.reload();
                } else {
                    layer.msg("提交失败");
                }
            }
        });
        return false;
    });
});

$(function () {
    $.ajax({
        url: "getStudent.do",
        success: function (data) {
            obj = data;
            $("#stu_name").val(data.stu_name);
        }
    });
})
