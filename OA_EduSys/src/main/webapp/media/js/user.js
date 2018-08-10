layui.use(['form', 'table'], function () {
    var form = layui.form, table = layui.table;

    table.render({
        elem: '#tbdata'
        , height: 500
        , width: 1200
        , url: 'userQueryByPage.do' //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'user_id', title: '用户ID', fixed: 'left'}
            , {field: 'user_no', title: '用户名',}
            , {field: 'user_name', title: '真实姓名',}
            , {field: 'role_name', title: '角色名称', templet: '#roleTpl'}
            , {
                field: 'status', width: '6%', title: '状态', templet: function (obj) {
                    var r;
                    switch (obj.status) {
                        //有效
                        case 1:
                            r = "<span class='layui-badge layui-bg-blue'>有效</span>";
                            break;
                        case 2:
                            r = "<span class='layui-badge layui-bg-gray'>无效</span>";
                            break;
                    }
                    return r;
                }
            }
            , {fixed: 'right', width: 180, title: '操作', align: 'center', toolbar: '#toolbar'}
        ]]
    });


    table.on('tool(tbop)', function (obj) {
        var layEvent = obj.event;
        var data = obj.data;
        console.log(data);
        if (layEvent == 'addRole') {
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: '500px'
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
                content: $("#roleModel")
                ,
                yes: function (index, layero) {
                    var role_id = $("input[name='role']");
                    var role_ids = [];
                    for (var i in role_id) {
                        if (role_id[i].checked)
                            role_ids.push(role_id[i].value);
                    }
                    var ids = {user_id: data.user_id, role_ids: role_ids};
                    $.ajax({
                        url: "updateMyRole.do",
                        type: "post",
                        data: ids,
                        success: function (data) {
                            if (data.code == 0) {
                                layer.msg(data.msg);
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    })
                },
                btn2: function () {
                    location.reload();
                }
            });
        } else if (layEvent == 'del') { //删除
            layer.confirm('是否确认删除?', function (index) {
                $.ajax({
                    url: "deleteUser.do",
                    data: "user_id=" + data.user_id,
                    success: function (data) {
                        if (data.code == 1) {
                            obj.del();//删除表格中的对应行数据
                            layer.close(index);
                            layer.msg(data.msg, {icon: 5});
                        } else {
                            layer.msg(data.msg, {icon: 6});
                        }
                    }
                });
            });
        }
    });


    var active = {
        addStudent: function () {
            //示范一个公告层
            layer.open({
                type: 2
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: ['1300px', '600px']
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                /*   btn: ['提交','关闭']
                   ,*/
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: 'studentAdd.html'
            });
        }
        , addEmployee: function () {
            //示范一个公告层
            layer.open({
                type: 2
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: ['1300px', '700px']
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                /*   btn: ['提交','关闭']
                   ,*/
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: 'employeeAdd.html'
            });
        }
    }

    $('#addStudent').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    $('#addEmployee').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    initData();

    function initData() {
        $.ajax({
            url: "roleQueryAll.do",
            success: function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    $("#roleList").append("<input type='checkbox' name='role' value='" + data[i].role_id + "' title='" + data[i].role_name + "' lay-skin='primary'>");
                    form.render("checkbox");
                }
            }
        });
    };
});