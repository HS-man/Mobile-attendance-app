package cn.jbolt.index;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

import cn.jbolt.common.model.Companybusiness;
/**
 * IndexController 指向系统访问首页
 * @author jbolt.cn
 * @email 909854136@qq.com
 * @date 2018年11月4日 下午9:02:52
 */
public class IndexController extends Controller {
	/**
	 * 首页Action
	 */
	
	public void index() {
        render("main.jsp");
		
	}
	@ActionKey("main") 
	public void test(){
    	render("main.jsp");
    }
	
	
}