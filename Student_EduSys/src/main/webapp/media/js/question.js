var obj;


layui.use(['table', 'form'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer;

    table.render({
        elem: '#tbdata'
        , url: 'getQuestion.do?stu_name=' + obj.stu_name
        , page: true
        , cols: [[
            {field: 'stu_name', width: '10%', title: '姓名', align: 'center'}
            , {field: 'ques_content', width: '50%', title: '问题内容', align: 'center'}
            , {field: 'createtime', width: '10%', title: '创建时间', align: 'center'}
            , {field: 'ques_reply', width: '30%', title: '回复', align: 'center'}
        ]]
    });

    form.on('submit(save)', function (data) {
        $.ajax({
            url: "saveQuestion.do",
            type: "post",
            data: {
                stu_name: $("#stu_name").val(),
                ques_content: $("#ques_content").val(),
            },
            success: function (data) {
                if (data.code == 1) {
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
