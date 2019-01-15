<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>印尼企业查</title>
<link rel="stylesheet" href="css1.css" type="text/css" charset="utf-8" />
<script type="text/javascript" src="method.js"></script>
<script type="text/javascript" src="jquery-form.js"></script>
<script type="text/javascript">
function CompanySearch(){
	document.getElementById("js-human").classList.remove("active");
	document.getElementById("js-company").classList.add("active");
	document.getElementById("input-human").classList.add("hidden");
	document.getElementById("input-company").classList.remove("hidden");
}
function HumanSearch(){
	document.getElementById("js-company").classList.remove("active");
	document.getElementById("js-human").classList.add("active");
	document.getElementById("input-company").classList.add("hidden");
	document.getElementById("input-human").classList.remove("hidden");
}
function search1(){
	$("#CompanyForm").ajaxSubmit({
					dataType: "json",
					success: function(data){
						if(data.flag) {
							window.location="manage";
						}
						else {
							alert(data.msg);
						}
					}
				});
}

</script>
<style type="text/css">
@charset "utf-8";
body{
	font-family:"微软雅黑";
	font-size:12pt;	
	background: #0CF;
}

div {
    display: block;
}
.home-title {
    display: inline-block;
    margin-bottom: 45px;
    margin-top:5px;
    font-size: 48px;
    line-height: 55px;
    letter-spacing: 6px;
    text-indent: 7px;
    color: #fff;
}
.text-center {
	text-align: center;
}
.tab-main {
    text-align: center;
    color: #fff;
	
}
.tab-main .item {
    display: inline-block;
    padding: 3px 6px;
    line-height: 1.42857143;
    margin-right: 40px;
    border-radius: 2px;
    font-size: 16px;
    cursor: pointer;
}
.tab-main .active.item {
	/* Visual */
	color: #0084ff;
	background-color: #fff;
}
.mt10{
	margin-top: 10px;
	
}
.hidden {
    display: none;
}

.home-group .input {
	width: 640px;
	border-color: transparent;
	line-height: 24px;
	font-size: 16px;
	padding: 5px 25px 5px 15px;
	vertical-align: middle;
}

.home-group .input-group-btn {
	width: 100px;
	border-left-color: #e0e0e0;
	color: #0084ff;
}
.home-group .input-group-btn:hover {
	border-color: #0084ff;
	background-color: #0084ff;
	color: #fff;
}


.btn {
	/* Box model */
	display: inline-block;
	padding: 2px 12px;
	border: 1px solid #f3f3f3;
	border-radius: 2px;
	margin-top: 10px;
	/* Typographic */
	font-size: 14px;
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

.result-list {
	background-color: #ffffff;
}
</style>
</head>

<body>
<div class="text-center">
<div class="home-title" style="text-align:center">
    印尼企业查
 </div>
<div class="tab-main">
	<div>
    	<div class="item js-tab active" id="js-company" onclick="CompanySearch()">
        	<div class="top">
            	<span>查企业</span>
            </div>
        </div>
    	<div class="item js-tab" id="js-human"  onclick="HumanSearch()">
        	<div class="top">
            	<span>查高管</span>
            </div>
        </div>
    	<div class="item" tab="js-relation" tyc-event-click tyc-event-ch="shouye.RelationSearch.Tab">
        	<div class="top">
            	<span>查关系</span>
            </div>
        </div>
    </div>
</div>
	<div class="mt10 js-search-container" id="input-company">
    	<div class="input-group home-group">
    		<form id="CompanyForm"  action="search" method="post">
            	<div class="live-search-wrap -index">
                	<input type="search" id="home-main-search" class="input -hg js-live-search-auto"  maxlength="50" name="CompanyName" placeholder="请输入企业名称" />
                	<input value="搜索" class="input-group-btn btn -hg" type="submit">
					<ul class="live-search-content hidden"></ul>
                </div>
            </form>
            
        </div>
    </div>
    <div class="mt10 hidden js-search-container" id="input-human">
    	<div class="input-group home-group">
    		<form autocomplete="off">
            	<div class="live-search-wrap -index">
                	<input type="search" id="home-human-search" class="input -hg js-live-search-auto" wrap-class="-index" livesearch-is-human="true" maxlength="50" click-selected="header.suggestToHuman" placeholder="请输入高管姓名" />
					<ul class="live-search-content hidden"></ul>
                </div>
            </form>
            <div class="input-group-btn btn -hg" id="search-human"s>
            <span>搜索</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>