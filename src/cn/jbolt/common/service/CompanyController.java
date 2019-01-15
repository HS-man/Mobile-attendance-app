package cn.jbolt.common.service;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import cn.jbolt.common.model.Companybusiness;


public class CompanyController extends Controller {
	static String Company="";	//输入框字符串
	static String WholeName="";	//企业全称
	static String Industry="";	//企业的业务
	static int totalPgae;		//总共的页数
	static int total;			//总共的记录数
	static int currentPage=1;		//当前页号
	static String[] exes;
	static String[] auditors;
	static int mode=1;			//1为按名字搜索企业 2为相似业务推荐
	public void index() {
    	render("main.jsp");
    }
	
	@ActionKey("search1") 
	public void search(){
		mode=1;
		Integer pageNumber=getParaToInt("pageNumber");
		if(pageNumber==null){
			pageNumber=1;
		}
		String company = getPara("CompanyName");//获取输入框数据
		Company=company;
		Page<Record> list=Companybusiness.dao.findByCompanyName(pageNumber,company);
		totalPgae=list.getTotalPage(); 
		total=list.getTotalRow();	   
		currentPage=pageNumber;
		setAttr("totolRecord", total);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
	}
	
	@ActionKey("pre") 
	public void PrePage(){
		if(currentPage==1){	
			currentPage=1;	//当前页是第一页
		}else{
			currentPage-=1;			//页数加1
		}
		if(mode==1){
			Page<Record> list=Companybusiness.dao.findByCompanyName(currentPage,Company);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==2){
			Page<Record> list=Companybusiness.dao.findBySimilarIndustry(currentPage, Industry);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==3){
			Page<Record> list=Companybusiness.dao.findBySameExecutives(currentPage,WholeName,exes,auditors);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}
	}
	@ActionKey("next") 
	public void NextPage(){
		if(currentPage==totalPgae){	
			currentPage=totalPgae;	//当前页是最后一页
		}else{
			currentPage+=1;			//页数加1
		}
		if(mode==1){
			Page<Record> list=Companybusiness.dao.findByCompanyName(currentPage,Company);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==2){
			Page<Record> list=Companybusiness.dao.findBySimilarIndustry(currentPage, Industry);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==3){
			Page<Record> list=Companybusiness.dao.findBySameExecutives(currentPage,WholeName,exes,auditors);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}
		
	}
	@ActionKey("jump") 
	public void JumpPage(){
		Integer pageNumber=getParaToInt("pageNumber");
		if(pageNumber==null){
			pageNumber=1;
		}
		currentPage=pageNumber;
		if(mode==1){
			Page<Record> list=Companybusiness.dao.findByCompanyName(currentPage,Company);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==2){
			Page<Record> list=Companybusiness.dao.findBySimilarIndustry(currentPage, Industry);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}else if(mode==3){
			Page<Record> list=Companybusiness.dao.findBySameExecutives(currentPage,WholeName,exes,auditors);
			setAttr("totolRecord", total);
			setAttr("totalPgae", totalPgae);
			setAttr("pageNumber", list.getPageNumber());
			setAttr("Company", list.getList());
			render("company_list.jsp");
		}
		
	}
	@ActionKey("detail") 
	public void CompanyDetail(){
		String CompanyName=getPara("company");
		WholeName=CompanyName;
		Record result=Companybusiness.dao.findall(CompanyName);
		Industry=result.getStr("Industry");
		setAttr("CompanyName", CompanyName);
		setAttr("StateCounty", result.get("StateCounty"));
		setAttr("City", result.get("City"));
		setAttr("Industry", result.getStr("Industry"));
		setAttr("KeyExecutives", result.get("KeyExecutives"));
		setAttr("NumberOfEmployees", result.get("NumberOfEmployees"));
		setAttr("LegalForm", result.get("LegalForm"));
		setAttr("FinancialAuditors", result.get("FinancialAuditors"));
		setAttr("ListedUnlisted", result.get("ListedUnlisted"));
		setAttr("OperationalStatus", result.get("OperationalStatus"));
		setAttr("ISIN", result.get("ISIN"));
		setAttr("NationalFiscalIDs", result.get("NationalFiscalIDs"));
		setAttr("Shareholders", result.get("Shareholders"));
		setAttr("MainProducts", result.get("MainProducts"));
		setAttr("PostalCode", result.get("PostalCode"));
		setAttr("Address", result.get("Address"));
		setAttr("Phone", result.get("Phone"));
		setAttr("Fax", result.get("Fax"));
		setAttr("Email", result.get("Email"));
		setAttr("Website", result.get("Website"));
		setAttr("AddressType", result.get("AddressType"));
		setAttr("BusinessDescriptionProducts", result.get("BusinessDescriptionProducts"));
		setAttr("Import", result.get("Import"));
		setAttr("Export", result.get("Export"));
		setAttr("Source", result.get("Source"));
		setAttr("IncorporationDate", result.get("IncorporationDate"));
		setAttr("EMISID", result.get("EMISID"));
		setAttr("Totaloperatingrevenue", result.get("Totaloperatingrevenue"));
		setAttr("FiscalYear", result.get("FiscalYear"));
		setAttr("Audited", result.get("Audited"));
		setAttr("Consolidated", result.get("Consolidated"));
		setAttr("F35", result.get("F35"));
		render("company_detail.jsp");
	}
	@ActionKey("similar") 
	public void SimilarIndustry(){
		mode=2;
		//Integer pageNumber=getParaToInt("pageNumber");
		Page<Record> list=Companybusiness.dao.findBySimilarIndustry(1, Industry);
		totalPgae=list.getTotalPage(); 
		total=list.getTotalRow();	   
		//currentPage=pageNumber;
		setAttr("totolRecord", total);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
	}
	@ActionKey("relative")
	public void RelativeCompany(){
		mode=3;
		Record r=Companybusiness.dao.findall(WholeName);
		String executives=r.get("KeyExecutives");
		String Auditors=r.getStr("FinancialAuditors");
		String[] exe=executives.split(",");
		String[] auditor=Auditors.split("[,&]");
		exes=new String[exe.length];
		auditors=new String[auditor.length];
		exes=exe.clone();
		auditors=auditor.clone();
		Page<Record> list=Companybusiness.dao.findBySameExecutives(1,WholeName,exes,auditors);
		totalPgae=list.getTotalPage(); 
		total=list.getTotalRow();	   
		setAttr("totolRecord", total);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
		
	}
}
