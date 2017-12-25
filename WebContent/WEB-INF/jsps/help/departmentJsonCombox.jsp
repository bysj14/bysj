<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/3/20
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsps/includeURL.jsp" %>

<%--级联菜单的使用--%>

<%--如果只需要获取学院下的教研室，则通过以下的方法来写级联菜单，需要将些代码放在form表单中，后台才能通过name属性获取--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <select class="form-control" id="schoolSelect" name="schoolSelect" onchange="schoolOnSelect()">
                <%--需要从后台传递一个schoolList的参数，里面存放了所有的学院--%>
                <option value="0">--请选择学院--</option>
                <c:forEach items="${schoolList}" var="school">
                    <option value="${school.id }"
                            class="selectSchool">${school.description}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-md-2">
            <select class="form-control " id="departmentSelect" name="departmentSelect"></select>
        </div>
        <div class="col-md-2">
            <button type="submit" class="btn btn-default " data-toggle="modal"
                    data-target="#addOrEditProjectTimeSpan">查询
            </button>
        </div>

    </div>
</div>
