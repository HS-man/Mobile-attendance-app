<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>印尼企业查</title>
<style type="text/css">
.name{
	display: inline-block;
	font-size: 20px;
	max-width: 620px;
	margin: 0;
	padding: 0;
	line-height: 30px;
	vertical-align: middle;
	color: #454545;
	font-weight: bold;
}
.table{
	background:#ccc;
	margin: 10px auto;
	border-collapse:collapse;
}
td{
	height:25px;
	line-height:25px;
	text-align:center;
	border:1px solid #ccc;
}
tr{
	background:#fff;
}
tr:hover{
	
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
.similar{
	float:right;
	margin-right:20px;

}

</style>
<script type="text/javascript">

</script>
</head>


<body>
<div class="box-container">
	<div><h1 class="name">#(CompanyName)</h1>
    <input type="button" name="submit" onclick="javascript:history.back(-1);" value="返回" style="float:right" class="input-group-btn btn -hg"/>
    <form  action="similar" method="post" class="similar">	
                	<input type="submit" value="相似企业推荐" class="input-group-btn btn -hg" style="float:right" ></form>
    <form  action="relative" method="post" class="similar">	
                	<input type="submit" value="关联企业" class="input-group-btn btn -hg" style="float:right" ></form>               
    </div>
    <table class="table">
    	<tbody class=>
        	
        	<tr>
            	<td width="15%">StateCounty</td>
                <td width="35%">#(StateCounty)</td>
                <td width="15%">City</td>
                <td width="35%">#(City)</td>
            </tr>
            <tr>
            	<td>KeyExecutives</td>
                <td>#(KeyExecutives)</td>
                <td>Shareholders</td>
                <td>#(Shareholders)</td>
            </tr>
            <tr>
            	<td>Industry</td>
                <td>#(Industry)</td>
                <td>LegalForm</td>
                <td>#(LegalForm)</td>
            </tr>
            <tr>
            	<td>ListedUnlisted</td>
                <td>#(ListedUnlisted)</td>
                <td>OperationalStatus</td>
                <td>#(OperationalStatus)</td>
            </tr>
            <tr>
            	<td>ISIN</td>
                <td>#(ISIN)</td>
                <td>NationalFiscalIDs</td>
                <td>#(NationalFiscalIDs)</td>
            </tr>
            <tr>
            	<td>NumberOfEmployees</td>
                <td>#(NumberOfEmployees)</td>
                <td>MainProducts</td>
                <td>#(MainProducts)</td>
            </tr>
            <tr>
            	<td>PostalCode</td>
                <td>#(PostalCode)</td>
                <td>Address</td>
                <td>#(Address)</td>
            </tr>
            <tr>
            	<td>Phone</td>
                <td>#(Phone)</td>
                <td>Fax</td>
                <td>#(Fax)</td>
            </tr>
            <tr>
            	<td>Email</td>
                <td>#(Email)</td>
                <td>Website</td>
                <td>#(Website)</td>
            </tr>
            <tr>
            	<td>AddressType</td>
                <td>#(AddressType)</td>
                <td>Consolidated</td>
                <td>#(Consolidated)</td>
                
            </tr>
            <tr>
            	<td>Import</td>
                <td>#(Import)</td>
                <td>Export</td>
                <td>#(Export)</td>
            </tr>
            <tr>
            	<td>IncorporationDate</td>
                <td>#(IncorporationDate)</td>
                <td>Source</td>
                <td>#(Source)</td>
            </tr>
            <tr>
            	<td>EMISID</td>
                <td>#(EMISID)</td>
                <td>Totaloperatingrevenue</td>
                <td>#(Totaloperatingrevenue)</td>
            </tr>
            <tr>
            	<td>FiscalYear</td>
                <td>#(FiscalYear)</td>
                <td>FinancialAuditors</td>
                <td>#(FinancialAuditors)</td>
            </tr>
            <tr>
            	<td>BusinessDescriptionProducts</td>
                <td colspan="3">#(BusinessDescriptionProducts)</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>