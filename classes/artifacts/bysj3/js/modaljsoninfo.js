/**
 * Created by zhan on 2016/4/9.
 */

/*写此方法的因为如果直接在select的option中写onclick函数，只有IE浏览器可以执行，基于chrome内核的浏览器并不能执行*/
/*因为在select加上onchange函数，通过此函数来获取对应的option的id*/
function schoolOnSelectModal() {
    var schoolSelectId = $("#schoolSelectModal option:selected").val();
    getDepartmentBySchoolIdModal(schoolSelectId);
}

function departmentOnSelectModal() {
    var departmentSelectId = $("#departmentSelectModal option:selected").val();
    getStudentClassByDepartmentIdModal(departmentSelectId);
}

function departmentOnSelectToMajorModal() {
    var departmentSelectId = $("#departmentSelectModal option:selected").val();
    getMajorByDepartmentIdModal(departmentSelectId);
}

/*
 function majorSelect(){
 var majorSelectId = $("#majorSelect option:selected").val();
 alert("majorId"+majorSelectId);
 getStudentClassByMajorId(majorSelectId);
 }
 */

/*根据学院的id来获取对应的教研室*/
function getDepartmentBySchoolIdModal(schoolId) {
    $.ajax({
        url: '/bysj3/getJsonInfo/getJsonDepartmentBySchoolId.html',
        data: {"schoolId": schoolId},
        dataType: 'json',
        type: 'POST',
        success: function (data) {
            $("#departmentSelectModal").empty();
            $("#studentClassModal").empty();
            var str = data.toString();
            var strs = str.split(",");
            $.each(strs, function (i, val) {
                if (i % 2 != 0) {
                    var nameId = strs[i - 1];
                    $("#departmentSelectModal").append("<option value='" + nameId + "'>" + val + "</option>");
                }
            });
        },
        error: function () {
            myAlert("发生错误，请稍后再试");
        }
    });
}

/*根据教研室的id来获取对应的专业*/
function getStudentClassByDepartmentIdModal(departmentId) {
    $.ajax({
        url: '/bysj3/getJsonInfo/getJsonStudentClassByDepartmentId.html',
        data: {"departmentId": departmentId},
        dataType: 'json',
        type: 'POST',
        success: function (data) {
            $("#studentClassModal").empty();
            var str = data.toString();
            var strs = str.split(",");
            $.each(strs, function (i, val) {
                if (i % 2 != 0) {
                    var nameId = strs[i - 1];
                    $("#studentClassModal").append("<option value='" + nameId + "'>" + val + "</option>");
                }
            });
        },
        error: function () {
            myAlert("错误，请稍后再试");
            return false;
        }
    });
}


function getMajorByDepartmentIdModal(departmentId) {
    $.ajax({
        url: '/bysj3/getJsonInfo/getJsonMajorByDepartmentId.html',
        data: {"departmentId": departmentId},
        dataType: 'json',
        type: 'POST',
        success: function (data) {
            $("#majorModal").empty();
            var str = data.toString();
            var strs = str.split(",");
            $.each(strs, function (i, val) {
                if (i % 2 != 0) {
                    var nameId = strs[i - 1];
                    $("#majorModal").append("<option value='" + nameId + "'>" + val + "</option>");
                }
            });
        },
        error: function () {
            myAlert("错误，请稍后再试");
            return false;
        }
    });
}
/*根据专业的id来获取对应的班级*/
/*function getStudentClassByMajorId(majorId){
 $.ajax({
 url: '/bysj3/getJsonInfo/getJsonStudentClassByMajorId.html',
 data: {"majorId":majorId},
 dataType: 'json',
 type: 'POST',
 success: function (data) {
 $("#studentClassSelect").empty();
 var str = data.toString();
 var strs = str.split(",");
 $.each(strs, function (i, val) {
 if (i % 2 != 0) {
 var nameId = strs[i - 1];
 $("#stduentClassSelect").append("<option value='"+nameId+"'>" + val + "</option>");
 }
 });
 },
 error: function () {
 alert("网络错误，请稍后再试");
 }
 });
 }*/
