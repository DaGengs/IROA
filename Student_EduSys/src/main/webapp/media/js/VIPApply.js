var obj;


layui.use(['table', 'form'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer;

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
