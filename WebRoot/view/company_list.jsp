<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css1.css" type="text/css" />
<script type="text/javascript" src="method.js"></script>
<script type="text/javascript" src="jquery-form.js"></script>
<title>印尼企业查</title>
</head>
<body>
<div class="result-list sv-search-container">
	<table>
    <caption><h1>学生信息</h1></caption>
        <thead>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>备注</th>
        <th rowspan="2">操作</th>
        </thead>
        <tbody>
        <c:forEach items="${student}" var="student">
        <tr>
        <th>${student.name}</th>
        <th>${student.age}</th>
        <th>${student.sex}</th>
        <th>${student.remark}</th>
        <th><a href="/students/edit/${student.id}">修改 </a><a href="/students/delete/${student.id}"> 删除</a></th>
        </tr>
        </c:forEach>
        </tbody>
            
        <tr>        
        <th colspan="5">总页数  ${pagination}/${page}    
        <a href="/students">首页</a>    
        <a href="/students/Previouspage/${pageNumber}-${pagination}">上一页</a>    
        <a href="/students/nextpage/${pageNumber}-${pagination}">下一页</a>    
        <a href="/students/trailerpage/">尾页</a>   
        <form action="/students/jumpPage/">
        <input type="text" name="number">
        <button type="submit">确定</button>
        </form>
        </th>
        </tr>

    </table>
</div>
</body>
</html>