package cn.jbolt.common.config;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;



public class HelloController extends Controller {
	/**
	 * Action可以有返回值，返回值可在拦截器中通过
	 * invocation.getReturnValue()获取到，以便进行render控制。
	 */
    public void index() {
    	render("main.html");
       
    }
    @ActionKey("/hello/test")
    public void test(){
    	render("main.html");
    }
}