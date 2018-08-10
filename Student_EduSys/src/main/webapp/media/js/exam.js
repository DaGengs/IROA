var obj;

layui.use(['table', 'form'], function () {
    var table = layui.table, form = layui.form, layer = layui.layer;

    table.render({
        elem: '#tbdata'
        , url: 'examQuery.do'
        , page: true
        , cols: [[
            {field: "exam_id", title: '序号', sort: true, align: 'center'}
            , {field: 'exam_title', title: '题目', align: 'center'}
            , {field: 'exam_content', title: '内容/答案', align: 'center'}
            , {field: 'user_name', title: '出题人', align: 'center'}
            , {field: 'exam_type', title: '类型', align: 'center'}
            , {field: 'createtime', title: '创建时间', align: 'center'}
            , {field: 'right', title: '操作', toolbar: "#barop"}
        ]]
    });

    table.on('tool(tbop)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            $("#exam_titles").html(data.exam_title);
            $("#exam_contents").html(data.exam_content);
            layer.open({
                type: 1
                , title: false //不显示标题栏
                , closeBtn: false
                , area: '800px;'
                , shade: 0.8
                , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                , btn: '确认关闭'
                , btnAlign: 'c'
                , moveType: 1 //拖拽模式，0或者1
                , content: $("#model")
                , yes: function () {
                    layer.closeAll();
                }
            });
        }
    });


    form.on('submit(save)', function (data) {
        $.ajax({
            url: "examAdd.do",
            type: "post",
            data: {
                user_name: $("#stu_name").val(),
                exam_title: $("#exam_title").val(),
                exam_content: $("#exam_content").val(),
                exam_type: $("#exam_type").val()
            },
            success: function (data) {
                if (data.code == 1) {
                    layer.msg(data.msg);
                    location.reload();
                } else {
                    layer.msg(data.msg);
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
