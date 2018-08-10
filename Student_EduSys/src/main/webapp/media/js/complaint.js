layui.use('form', function () {
    var form = layui.form, layer = layui.layer;

    form.on('submit(save)', function (data) {
        $.ajax({
            url: "saveComplaint.do",
            type: "post",
            data: {
                comp_content: $("#comp_content").val(),
            },
            success: function (data) {
                if (data.code == 1) {
                    layer.msg("提交成功");
                } else {
                    layer.msg("提交失败");
                }
            }
        });
        return false;
    });
});

