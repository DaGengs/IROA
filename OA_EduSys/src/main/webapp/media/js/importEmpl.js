layui.use(['form', 'upload'], function () {

    var form = layui.form, layer = layui.layer, upload = layui.upload;

    var uploadInst = upload.render({
        elem: '#upload' // 绑定元素
        , url: 'importEmpl.do' // 上传接口
        , accept: 'file'
        , before: function (obj) {
            this.data = {"dept_id": $("#dept_id").val()}
        }
        , done: function (res) {
            // 上传完毕回调
            if (res.code == 1) {
                layer.msg(res.msg);
            } else {
                layer.msg(res.msg);
            }
        },
        error: function () {
            // 请求异常回调
        }
    });

});

$(function () {
    $.ajax({
        url: "getDepartment.do",
        success: function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                $("#dept_id").append("<option value='" + data[i].dept_id + "'>" + data[i].dept_name + "</option>");
            }
        }
    });
});

