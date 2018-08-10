$(function () {
    $.ajax({
        url: "getEmplInfo.do",
        success: function (data) {
            console.log(data);
            $("#empl_name").html(data.empl_name);
            $("#empl_img").attr("src", "/resources/employeeImgs/" + data.empl_imgUrl);
            $("#empl_no").val(data.empl_no);
            $("#empl_name1").val(data.empl_name);
            $(":radio[name='empl_gender'][value='" + data.empl_gender + "']").prop("checked", "checked");
            $("#empl_phone").val(data.empl_phone);
            $("#empl_email").val(data.empl_email);
            $("#dept_name").val(data.department.dept_name);
            $("#createDate").val(data.createDate);
            $("#imgUrl").attr("src", "/resources/employeeImgs/" + data.empl_imgUrl);
            $("#e_no").val(data.empl_no);
        }
    });

});

var message;
var element;
layui.config({
    base: 'media/layui/lay/modules/'
}).use(['app', 'message', 'layer', 'element'], function () {
    var app = layui.app,
        $ = layui.jquery,
        layer = layui.layer;
    message = layui.message;
    element = layui.element;
    //主入口
    app.set({
        type: 'iframe'
    }).init();

    var active = {
        showInfo: function () {
            //示范一个公告层
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: '800px;'
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                btn: '确认关闭'
                ,
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: $("#infoModel")
                ,
                success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({});
                }
            });
        }
        , editPwd: function () {
            //示范一个公告层
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: '800px;'
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                btn: ['提交', '关闭']
                ,
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: $("#editPwd")
                ,
                yes: function (index, layero) {
                    var old_pwd = $("#old_pwd").val();
                    var new_pwd = $("#new_pwd").val();
                    var rel_pwd = $("#rel_pwd").val();
                    if (old_pwd == "") {
                        layer.msg("请输入密码");
                        return false;
                    }
                    if (new_pwd == "") {
                        layer.msg("请输入密码");
                        return false;
                    }
                    if (rel_pwd == "") {
                        layer.msg("请输入密码");
                        return false;
                    }
                    $.ajax({
                        url: "getPassword.do",
                        type: "post",
                        data: {
                            password: old_pwd
                        },
                        success: function (data) {
                            if (data.code == 0) {
                                layer.msg(data.msg);
                                return false;
                            } else {
                                if (new_pwd != rel_pwd) {
                                    layer.msg("两次密码不一致");
                                    return false;
                                }
                                $.ajax({
                                    url: "edidPassword.do",
                                    type: "post",
                                    data: {
                                        new_password: new_pwd
                                    },
                                    success: function (data) {
                                        if (data.code == 1) {
                                            layer.msg(data.msg);
                                            setInterval("location.href='loginout.do'", 5000);
                                        } else {
                                            layer.msg(data.msg);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }

            });
        }
    }

    $('#a1').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    $('#a2').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });


});