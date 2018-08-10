layui.use(['form', 'table', 'tree'], function () {
    var form = layui.form, table = layui.table;

    table.render({
        elem: '#tbdata'
        , height: 500
        , width: 1200
        , url: 'menuQueryByPage.do' //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'menu_id', title: 'ID', fixed: 'left'}
            , {field: 'menu_name', title: '权限名称',}
            , {
                field: 'menu_p_name', title: '上级权限', templet: function (d) {
                    return d.menu_p_name == null ? "无" : d.menu_p_name
                }
            }
            , {field: 'menu_url', title: '菜单路径',}
            , {field: 'menu_icon', title: '权限图标', templet: '<i class="layui-icon">{{ d.menu_icon }}</i>'}
            , {fixed: 'right', width: 150, title: '操作', align: 'center', toolbar: '#toolbar'}
        ]]
    });

    var active = {
        addMenu: function () {
            //示范一个公告层
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: 2
                ,
                area: '400px'
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
                content: $("#addModel")
                ,
                yes: function (index, layero) {
                    var menu = {
                        menu_name: $("#menu_name").val(),
                        menu_p_id: $("#menu_p_id").val(),
                        menu_url: $("#menu_url").val(),
                        menu_icon: $("#menu_icon").val()
                    };

                    $.ajax({
                        url: "saveMenu.do",
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify(menu),
                        success: function (data) {
                            if (data.code == 0) {
                                layer.msg(data.msg);
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    });
                },
                btn2: function () {
                    location.reload();
                }
            });
        }
    }

    $('#add').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    initData();

    function initData() {
        $.ajax({
            url: "menuQueryAll.do",
            success: function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    $("#menu_p_name").append("<option value='" + data[i].menu_id + "'>" + data[i].menu_name + "</option>");
                }
                form.render("select");
            }
        })
    }
});
