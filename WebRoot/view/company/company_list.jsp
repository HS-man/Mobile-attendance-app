<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css1.css" type="text/css" />
<link rel="stylesheet" href="company/page.css" />
<script type="text/javascript" src="method.js"></script>
<script type="text/javascript" src="jquery-form.js"></script>
<title>印尼企业查</title>
<style type="text/css">
html, body {
	padding: 0;
	margin: 0;
	height: 100%;
	font-family: gotham, helvetica, arial, sans-serif;
	font-size: 16px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

tr {
	height: 30px;
}

.table-body table tr:nth-child(2n+1) {
	background: #fff;
}

.table-body table tr:nth-child(2n) {
	background: #f8f8f8;
}

.table-inner {
	position: relative;
	width: 1000px;
	height: 800px;
	margin: 0 auto;
    margin-top: 20px;
	text-align: center;
}

.table-inner table {
	width: 100%;
	table-layout: fixed;
}

.table-head {
	height: 42px;
	line-height: 42px;
	color: #fff;
	background-color: #408ec9;
	
}

.table-body {
	width: 100%;
	position: absolute;
	top: 42px;
	bottom: 42px;
	overflow-x: hidden;
	overflow-y: scroll;
}

.table-body tr {
	height: 80px;
}

.page-wrap {
	position: absolute;
	bottom: -10px;
	height: 60px;
	line-height: 42px;
	width: 100%;
	background: #dbdbdb;
	left: 2px;
}

.current {
	display: inline-block;
	height: 26px;
	line-height: 26px;
	width: 26px;
	text-align: center;
	color: #666;
	border: solid 1px #a0a0a0;
	cursor: pointer;
}

.page-info>input[type=text] {
	height: 20px;
	line-height: 20px;
	width: 26px;
}
ul li{ float:left; margin-left:20px; list-style-type:none;}
.input-group-btn {
	width: 100px;
	border-left-color: #e0e0e0;
	color: #0084ff;
}
.input {
	width: 100px;
	line-height: 24px;
	font-size: 16px;
	padding: 5px 25px 5px 15px;
	vertical-align: middle;
}
.btn {
	/* Box model */
	display: inline-block;
	padding: 2px 12px;
	border: 1px solid #f3f3f3;
	border-radius: 2px;
	/* Typographic */
	font-size: 20px;
	text-align: center;
	line-height: 18px;
	font-weight: normal;
	/* Visual */
	background-color: #fff;
	color: #202020;
	/* Other */
	cursor: pointer;
	-webkit-transition: all 0.3s linear;
	transition: all 0.3s linear;
}
.input-group-btn{
	border-color: #0084ff;
	background-color: #0084ff;
	color: #fff;
}
</style>
<script type="text/javascript">


</script>
</head>
<body>
<div class="table-inner">
        <div class="table-head">
        
           <span>为你查找到#(totolRecord)家公司</span>
           
        </div>
        <div class="table-body">
            <table width="130">
            	<thead>
                	<tr>
                	<td>企业名称</td>
                    <td>城市</td>
                    <td>省份</td>
                </tr>
                </thead>
                <tbody id="tbody">
                #for(x:Company)
                <tr>
                	<td>#(x.CompanyName)</td>
                    <td>#(x.City)</td>
                    <td>#(x.StateCounty)</td>
                    <td><form id="DetailForm" action="detail" method="post">	
                    <input type="text" hidden="true" name="company" value="#(x.CompanyName)" />
                	<input type="submit" value="详细" class="input-group-btn btn -hg"></form></td>
                </tr>
                #end
                
                </tbody>
            </table>
  		</div>
        <div  class="page-wrap">
            <ul class="pagination">
            
            <li><a name="currentPage">当前页：#(pageNumber)</a></li>
            <li><form id="PrePage" action="pre" method="post">
                	<input type="submit" value="上一页" class="input-group-btn btn -hg"></form></li>
            <li><form id="NextPage" action="next" method="post">
                	<input type="submit" value="下一页" class="input-group-btn btn -hg"></form></li>
            <li><a name="currentPage">总页数：#(totalPgae)</a></li>  
            <li><form id="JumpPage" action="jump" method="post">
                <input type="search" class="input -hg js-live-search-auto"  maxlength="4" name="pageNumber" value="" />
                <input type="submit" value="跳转" class="input-group-btn btn -hg" /></form></li>
            <li><form id="returnForm" action="main" method="post">	
                	<input type="submit" value="返回" class="input-group-btn btn -hg" style="float:right" ></form></li>
            </ul>
        </div>
</div>

</body>
</html>