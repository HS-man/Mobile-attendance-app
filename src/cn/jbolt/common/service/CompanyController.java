package cn.jbolt.common.service;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import cn.jbolt.common.model.Companybusiness;


public class CompanyController extends Controller {
	static String Company="";
	static int totalPgae;		//总共的页数
	static int total;			//总共的记录数
	static int currentPage;		//当前页号
	public void index() {
    	render("main.jsp");
    }
	
	@ActionKey("search1") 
	public void search(){
		Integer pageNumber=getParaToInt("pageNumber");
		System.out.println(pageNumber);
		if(pageNumber==null){
			pageNumber=1;
		}
		String company = getPara("CompanyName");//获取输入框数据
		Company=company;
		Page<Record> list=Companybusiness.dao.findByCompanyName(pageNumber,company);
		totalPgae=list.getTotalPage(); 
		total=list.getTotalRow();	   
		currentPage=pageNumber;
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
		Page<Record> list=Companybusiness.dao.findByCompanyName(currentPage,Company);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
	}
	@ActionKey("next") 
	public void NextPage(){
		if(currentPage==totalPgae){	
			currentPage=totalPgae;	//当前页是最后一页
		}else{
			currentPage+=1;			//页数加1
		}
		Page<Record> list=Companybusiness.dao.findByCompanyName(currentPage,Company);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
	}
	@ActionKey("jump") 
	public void JumpPage(){
		Integer pageNumber=getParaToInt("pageNumber");
		if(pageNumber==null){
			pageNumber=1;
		}
		
		Page<Record> list=Companybusiness.dao.findByCompanyName(pageNumber,Company);
		setAttr("totalPgae", totalPgae);
		setAttr("pageNumber", list.getPageNumber());
		setAttr("Company", list.getList());
		render("company_list.jsp");
	}
}
