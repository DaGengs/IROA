$(function () {
    $.ajax({
        url: "getStudent.do",
        success: function (data) {
            $("#stu_name").html(data.stu_name);
        }
    })
})