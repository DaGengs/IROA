layui.use(['form', 'layedit', 'laydate', 'upload'],
    function () {
        var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate,
            upload = layui.upload;
        // 日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        // 执行实例
        var uploadInst = upload.render({
            elem: '#upPhoto' // 绑定元素
            ,
            url: "upPhoto.do" // 上传接口
            , before: function (obj) {
                this.data = {"stu_no": $("#stu_no").val()};
                obj.preview(function (index, file, result) {
                    $('#photo').attr('src', result);
                });
            },
            done: function (res) {
                // 上传完毕回调
                if (res.code == 0) {
                    layer.msg("上传成功");
                    $("#photo").attr("src", "/resources/studentImgs/" + res.msg);
                    $("#photo_url").val(res.msg);
                    $("#btn").removeAttr("disabled");
                } else {
                    layer.msg(res.msg);
                }
            },
            error: function () {
                // 请求异常回调
            }
        });
        /*var uploadInst2 = upload.render({
            elem : '#upCard_pre' // 绑定元素
            ,
            url : 'upCard_pre.do' // 上传接口
            ,before: function(obj) {
                this.data={"stu_no": $("#stu_no").val()};
                obj.preview(function(index, file, result){
                    $('#card_p').attr('src', result);
                });
            },
            done : function(res) {
                // 上传完毕回调
                if (res.code == 0) {
                    layer.msg("上传成功");
                    $("#card_p").attr("src","/resources/studentImgs/"+res.msg);
                    $("#card_pre").val(res.msg);
                    $("#btn").removeAttr("disabled");
                } else {
                    layer.msg(res.msg);
                }
            },
            error : function() {
                // 请求异常回调
            }
        });
        var uploadInst3 = upload.render({
            elem : '#upCard_suf' // 绑定元素
            ,
            url : 'upCard_suf.do' // 上传接口
            ,before: function(obj) {
                this.data={"stu_no": $("#stu_no").val()};
                obj.preview(function(index, file, result){
                    $('#card_s').attr('src', result);
                });
            },
            done : function(res) {
                // 上传完毕回调
                if (res.code == 0) {
                    layer.msg("上传成功");
                    $("#card_s").attr("src","/resources/studentImgs/"+res.msg);
                    $("#card_suf").val(res.msg);
                    $("#btn").removeAttr("disabled");
                } else {
                    layer.msg(res.msg);
                }
            },
            error : function() {
                // 请求异常回调
            }
        });
*/
        form.on('select(prov_name)', function (data) {
            $.ajax({
                url: "getCity.do",
                data: {
                    pno: data.value
                },
                success: function (data) {
                    $("#city_name").html("");
                    for (var i = 0; i < data.length; i++) {
                        $("#city_name").append("<option value='" + data[i].no + "'>" + data[i].name + "</option>");
                        form.render('select');
                    }
                }
            });
        });

        form.on('select(city_name)', function (data) {
            $.ajax({
                url: "getCounty.do",
                data: {
                    cno: data.value
                },
                success: function (data) {
                    $("#county_name").html("");
                    for (var i = 0; i < data.length; i++) {
                        $("#county_name").append("<option value='" + data[i].no + "'>" + data[i].name + "</option>");
                        form.render('select');
                    }
                }
            });
        });

        // 监听提交
        form.on('submit(save)', function (data) {

            var contact = {
                stu_no: $("#stu_no").val(),
                cont_name: $("#cont_name").val(),
                cont_rel: $("#cont_rel").val(),
                cont_phone: $("#cont_phone").val(),
                cont_addr: $("#cont_addr").val()
            };

            var address = {
                stu_no: $("#stu_no").val(),
                prov_name: $("#prov_name").val(),
                city_name: $("#city_name").val(),
                county_name: $("#county_name").val(),
                addr_detail: $("#addr_detail").val(),
            };

            var student = {
                stu_no: $("#stu_no").val(),
                stu_schoolName: $("#stu_schoolName").val(),
                stu_education: $("#stu_education").val(),
                stu_origin: $("#stu_origin").val(),
                photo_url: $("#photo_url").val(),
                card_pre: $("#card_pre").val(),
                card_suf: $("#card_suf").val(),
                contact: contact,
                address: address
            };
            console.log(student);
            $.ajax({
                url: "updateInfo.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(student),
                success: function (data) {
                    if (data.code == 1) {
                        layer.msg(data.msg);
                    } else {
                        layer.msg(data.msg);
                    }
                }
            });
        });
        initData();

        function initData() {
            $.ajax({
                url: "getStudent.do",
                success: function (data) {

                    $("#stu_no").val(data.stu_no);
                    $("#stu_idNumber").val(data.stu_idNumber);
                    $("#stu_phone").val(data.stu_phone);
                    $("#stu_QQ").val(data.stu_QQ);
                    $("#stu_name").val(data.stu_name);
                    $("#class_name").val(data.classes.class_name);
                    $("#stu_schoolName").val(data.stu_schoolName);
                    $("#stu_education").val(data.stu_education);
                    $("#stu_introno").val(data.stu_introno);
                    $("#createtime").val(data.createtime);
                    $("#status").val(data.status == 1 ? "在校" : "毕业");
                    if (data.address != null) {
                        /*	$("#prov_name").val(data.address.prov_name);
                            $("#city_name").val(data.address.city_name);
                            $("#county_name").val(data.address.county_name);*/
                        $("#location")[0].style.display = "none";
                        $("#addr_detail").val(data.address.prov_name + " " + data.address.city_name + " " + data.address.county_name + " " + data.address.addr_detail);
                    }
                    $("#stu_origin").val(data.stu_origin);
                    $("#cont_name").val(data.contact.cont_name);
                    $("#cont_rel").val(data.contact.cont_rel);
                    $("#cont_phone").val(data.contact.cont_phone);
                    $("#cont_addr").val(data.contact.cont_addr);
                    $("#photo").attr("src", "/resources/studentImgs/" + data.photo_url);
                    $("#card_p").attr("src", "/resources/studentImgs/" + data.photo_url);
                    $("#card_s").attr("src", "/resources/studentImgs/" + data.photo_url);
                }
            });

        }
    });
$(function () {


    $.ajax({
        url: "getProvince.do",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#prov_name").append("<option value=" + data[i].no + ">" + data[i].name + "</option>");
            }
        }
    });
});

