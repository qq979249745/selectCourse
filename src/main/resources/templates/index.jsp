<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>员工管理</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-8">
            <button class="btn btn-success" id="add_empl_btn" data-toggle="modal" >新增</button>
            <div class="modal fade" id="add_empl_modal">
                <div class="modal-dialog" >
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" ><span >&times;</span></button>
                            <h4 class="modal-title">员工添加</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="empl_name_input" class="col-sm-2 control-label">员工姓名：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="empName" class="form-control" id="empl_name_input" placeholder="员工姓名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="empl_emai_input" class="col-sm-2 control-label">邮箱：</label>
                                    <div class="col-sm-10">
                                        <input type="email" name="email" class="form-control" id="empl_emai_input" placeholder="邮箱">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class=" col-sm-10">
                                        <label  class="col-sm-2 control-label">性别：</label>
                                        <div class="col-sm-10">
                                            <label class="radio-inline">
                                                <input checked type="radio" name="gender" id="empl_gender1_input" value="男"> 男
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="gender" id="empl_gender2_input" value="女"> 女
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class=" col-sm-10">
                                        <label for="empl_department_input"  class="col-sm-2 control-label">部门：</label>
                                        <div class="col-sm-10">
                                            <select id="empl_department_input" name="dId" class="form-control">
                                                <option value="1"></option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button id="add_click" type="button" class="btn btn-primary">添加</button>
                        </div>
                    </div>
                </div>
            </div>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="emp_table" class="table table-hover table-striped table-responsive">
                <thead>
                <tr>
                    <th>#</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>部门</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6" id="page_info">
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="page_nav">
                </ul>
            </nav>
        </div>
    </div>
</div>

<script type="text/javascript" rel="script" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" rel="script" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var total;
    $(function () {
        toPageNum(1);
        $("#add_empl_btn").click(function () {
            $.ajax({
               url:'depts',type:'get',
               success:function (result) {
                   console.log(result);
                   $('#empl_department_input').empty();
                   $.each(result.extend.depts,function (index,item) {
                       $('#empl_department_input').append($("<option></option>").append(item.deptName).attr('value',item.deptId));
                   });
               }
            });
            $('#add_empl_modal').modal({
                backdrop:'static'
            });
        });
        $("#add_click").click(function () {
            $.ajax({
                url:'emp',
                data:$("#add_empl_modal form").serialize(),
                type:'post',
                success:function (result) {
                    console.log(result);
                    if (result.code==100){
                        $('#add_empl_modal').modal('hide');
                        toPageNum(total);
                    }else {

                    }
                }
            })
        })
        
    });
    function toPageNum(pn) {
        $.ajax({
            url:"emps",
            data:"pn="+pn,
            type:"get",
            success:function (result) {
                console.log(result);
                build_emps_tables(result.extend.pageInfo.list);
                build_page_info(result.extend.pageInfo);
                build_page_nav(result.extend.pageInfo);
            }
        });
    }
    function build_emps_tables(result) {
        $("#emp_table tbody").empty();
        $.each(result,function (index,item) {
            var empId=$("<td></td>").append(item.empId);
            var empName=$("<td></td>").append(item.empName);
            var gender=$("<td></td>").append(item.gender);
            var email=$("<td></td>").append(item.email);
            var deptName=$("<td></td>").append(item.department.deptName);
            var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-edit")).append("编辑");
            var trashBtn=$("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            var btnTd=$("<td></td>").append(editBtn," ",trashBtn);
            $("<tr></tr>").append(empId,empName,gender,email,deptName,btnTd).appendTo("#emp_table tbody");
        })
    }
    function build_page_info(result) {
        $("#page_info").empty();
        $("#page_info").append("当前第"+result.pageNum+"页，总"+result.pages+"页，总"+result.total+"条记录。")
        total=result.pages;
    }
    function build_page_nav(result) {
        $("#page_nav").empty();
        var firstLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","javascript:toPageNum(1);"));
        var preLi=$("<li></li>").append($("<span></span>").append("&laquo;")).click(function (){toPageNum(result.prePage)});
        var nextLi=$("<li></li>").append($("<span></span>").append("&raquo;")).click(function (){toPageNum(result.nextPage)});
        var lastLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","javascript:toPageNum("+result.pages+");"));

        if(!result.hasPreviousPage){
            firstLi.addClass("disabled");
            preLi.addClass("disabled").unbind("click");
        }
        if(!result.hasNextPage){
            nextLi.addClass("disabled").unbind("click");
            //lastLi.addClass("disabled").firstChild().removeAttr("href");
        }
        $("#page_nav").append(firstLi,preLi);
        $.each(result.navigatepageNums,function (index,item) {
            var numLi=$("<li></li>").append($("<a></a>").append(item).attr("href","javascript:toPageNum("+item+");"));
            if (item==result.pageNum) {
                numLi.addClass("active");
            }
            $("#page_nav").append(numLi);
        });
        $("#page_nav").append(nextLi,lastLi);
    }
</script>
</body>
</html>
