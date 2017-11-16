/**
 * 添加学生信息
 */
function addStu(){
    var name = $('#name').val();
    var age = $('#age').val();
    var userjson = {"name": name,"age":age};
    if(name==""||name==null){
        alert("姓名不能为空");
        return false;
    }
    if(age==""||age==null){
        alert("年龄不能为空");
        return false;
    }
    $.ajax({
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        url: 'stuadd.json',
        data: JSON.stringify(userjson),
        dataType: 'json',
        success: function (data) {
            alert("添加学生成功！")
            window.location='stu.html';
        }
    });
}

$(document).ready(function(){
    $("#checkAll").click(function () {
        if (this.checked) {

            $("input[name='ids']").prop("checked", true);
        } else {

            $("input[name='ids']").removeAttr("checked", false);
        }
    });
});

/*$(document).ready(function(){
    var idsstr = "";
    var isc = "";
    $("input[name=ids]").each(function(){ //遍历table里的全部checkbox
        idsstr += $(this).val() + ","; //获取所有checkbox的值
        if($(this).attr("checked")) //如果被选中
            isc += $(this).val() + ","; //获取被选中的值
    });
    if(idsstr.length > 0) //如果获取到
        idsstr = idsstr.substring(0, idsstr.length - 1); //把最后一个逗号去掉
    if(isc.length > 0) //如果获取到
        isc = isc.substring(0, isc.length - 1); //把最后一个逗号去掉
    alert("所有checkbox的值：" + idsstr);
    alert("被选中checkbox的值：" + isc);
});*/

function del() {
    var ids = new Array();
    $("input[name=ids]").each(function(){
        if($(this).prop("checked")) {
            ids.push($(this).val());
        }
    });
    if(ids.length > 0){
        /!* var idsJSON={"ids":ids.toString()};*!/
        $.ajax({
            type: 'POST',
            // contentType: "application/json;charset=utf-8",
            url: 'delstu.json',
            data: {"ids": ids.toString()},
            //data: JSON.stringify(idsJSON),
            dataType: "json",
            success: function (data) {
                alert("删除成功。");
                window.location='stu.html';
            }
        });
    }
}


function delone() {
    if ($('#chkid').prop("checked")){
        var id = $(this).val();
       // var idJson = {"id":id};
        $.ajax({
            type: 'POST',
            contentType: "application/json;charset=utf-8",
            url: 'delstu.json',
            data: {"id":id},
           // data: JSON.stringify(idJson),
            dataType: "json",
            success: function (data) {
                alert("删除成功。");
                window.location='stu.html';
            }
        });
    };
}




