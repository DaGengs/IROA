layui.use(['form', 'layedit', 'laydate', 'upload', 'table'],
    function () {
        var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate,
            upload = layui.upload, table = layui.table;
        // 日期
        laydate.render({
            elem: '#createDate'
        });

        // 执行实例
        var uploadInst = upload.render({
            elem: '#upload' // 绑定元素
            ,
            url: 'fileupload.do' // 上传接口
            , before: function (obj) {
                this.data = {"empl_no": $("#empl_no").val()}
            },
            done: function (res) {
                // 上传完毕回调
                if (res.code == 0) {
                    layer.msg("上传成功");
                    $("#imgUrl").attr("src", "/resources/employeeImgs/" + res.msg);
                    $("#empl_imgUrl").val(res.msg);
                    $("#btn").removeAttr("disabled");
                } else {
                    layer.msg(res.msg);
                }
            },
            error: function () {
                // 请求异常回调
            }
        });

        table.render({
            elem: '#tbdata'
            , url: 'employeeQuery.do'
            , page: true
            , cols: [[
                {field: "empl_no", title: '员工编号', align: 'center'}
                , {field: 'empl_name', title: '员工姓名', align: 'center'}
                , {field: 'dept_id', title: '所属部门', align: 'center', templet: '<div>{{d.department.dept_name}}</div>'}
                , {field: 'empl_gender', title: '性别', align: 'center'}
                , {field: 'empl_phone', title: '联系方式', align: 'center'}
                , {field: 'empl_email', title: '邮箱', align: 'center'}
                , {field: 'createDate', title: '入职时间', align: 'center'}
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
                        url: "employeeDelete.do",
                        type: "POST",
                        data: "empl_no=" + data.empl_no,
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
                location.href = "employeeUpdate.html?d=" + encodeURI(JSON.stringify(data));
            }
        });

        //监听提交
        form.on('submit(save)', function (data) {
            var employee = {
//							empl_no: $("#empl_no").val(),
                empl_name: $("#empl_name").val(),
                empl_gender: $('input:radio:checked').val(),
                empl_phone: $("#empl_phone").val(),
                empl_imgUrl: $("#empl_imgUrl").val(),
                empl_email: $("#empl_email").val(),
                dept_id: $("#dept_id").val(),
                createDate: $("#createDate").val()
            };

            $.ajax({
                url: "employeeAdd.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(employee),
                success: function (data) {
                    console.log(data);
                    if (data.code == 1) {
                        layer.msg(data.msg, {icon: 6});
                        // location.href="employeeList.html";
                    } else {
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            })
            return false;
        });
        //监听提交
        form.on('submit(update)', function (data) {
            var employee = {
                empl_no: $("#empl_no").val(),
                empl_name: $("#empl_name").val(),
                empl_gender: $('input:radio:checked').val(),
                empl_phone: $("#empl_phone").val(),
                empl_imgUrl: $("#empl_imgUrl").val(),
                empl_email: $("#empl_email").val(),
                dept_id: $("#dept_id").val(),
                createDate: $("#createDate").val()
            };

            $.ajax({
                url: "employeeUpdate.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(employee),
                success: function (data) {
                    console.log(data);
                    if (data.code == 1) {
                        layer.msg(data.msg, {icon: 6});
                        location.href = "employeeList.html";
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
                $("#dept_id").append("<option value='" + data[i].dept_id + "'>" + data[i].dept_name + "</option>");
            }
        }
    });
});