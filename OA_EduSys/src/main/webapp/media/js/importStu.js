layui.use(['form', 'upload'], function () {

    var form = layui.form, layer = layui.layer, upload = layui.upload;

    var uploadInst = upload.render({
        elem: '#upload' // 绑定元素
        , url: 'importStu.do' // 上传接口
        , accept: 'file'
        , before: function (obj) {
            this.data = {"class_no": $("#class_name").val()}
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

    $(function () {
        $.ajax({
            url: "getClasses.do",
            success: function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    $("#class_name").append("<option value='" + data[i].class_no + "'>" + data[i].class_name + "</option>");
                }
                form.render("select");
            }
        });
    });

});



