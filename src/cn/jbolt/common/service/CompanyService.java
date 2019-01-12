package cn.jbolt.common.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class CompanyService {
	static int count = 0;
	 
    
    /// <summary>
    ///  获取总数量
    /// </summary>

   public static int getCount(){
       
       String sql="select count(*) as count from companybusiness";
       
       count = Integer.parseInt(Db.findFirst(sql).getLong("count").toString());
       
       return count;
   }
   
   /// <summary>
   ///  获取当前页面列表
   /// </summary>    
   public static List<Record> get(Page1 page) {

          List<Record> list = null;
          
          int start = (page.getPageIndex() - 1) * page.getPageSize();
          
          int pageSize = page.getPageSize();

          String sql = "select * from companybusiness limit "+start+","+pageSize+" ";
          
          list = Db.find(sql);
          return list;
       }
}
