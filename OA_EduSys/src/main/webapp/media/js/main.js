layui.use('table', function () {
    var table = layui.table;

    var table = layui.table;

    //第一个实例
    table.render({
        elem: '#tbdata'
        , height: 315
        , url: 'getLoginlog.do' //数据接口
        , cols: [[ //表头
            {field: 'empl_no', title: '登录账户'}
            , {field: 'ip', title: '登录IP'}
            , {field: 'location', title: '登录城市'}
            , {field: 'createtime', title: '登录时间'}
        ]]
    });

});