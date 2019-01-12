package cn.jbolt.common.config;

import org.eclipse.jetty.server.Authentication.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

import cn.jbolt.common.model.Companybusiness;
import cn.jbolt.common.model.Deals;
import cn.jbolt.common.model.Relation;
import cn.jbolt.common.model._MappingKit;

public class DemoConfig extends JFinalConfig {
	/**
	 * 配置JFinal常量值，如开发模式常量devMode的配置，
	 * 如下代码配置了JFinal运行在开发模式
	 *  在开发模式下，JFinal会对每次请求输出报告，
	 *  如输出本次请求的URL、Controller、Method以及请求所携带的参数。
	 */
	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		PropKit.use("demo_config.txt");
			arg0.setDevMode(PropKit.getBoolean("devMode"));
	}
	/**
	 * 向模板引擎中添加了三个定义了 template function的模板文件
	 */
	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub
		arg0.addSharedFunction("/view/common/layout.html");
		arg0.addSharedFunction("/view/common/paginate.html");
		arg0.addSharedFunction("/view/admin/common/layout.html");
	}
	
	/*
	 * 用来配置JFinal的Handler
	 * 如下代码配置了名为ResourceHandler的处理器
	 * Handler可以接管所有web请求，并对应用拥有完全的控制权
	 */
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 *此方法用来配置JFinal的全局拦截器，全局拦截器将拦截所有 action请求
	 *除非使用@Clear在Controller中清除
	 *如下代码配置了名为AuthInterceptor的拦截器
	 *Interceptor 配置粒度分为 Global、Inject、Class、Method四个层次，其中以上代码配置粒度为全局
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * 用来配置JFinal的Plugin
	 * 配置了Druid数据库连接池插件与ActiveRecord数据库访问插件
	 */
	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		arg0.add(dp);
	    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
	    arp.addMapping("companybusiness","CompanyId",Companybusiness.class);
	    arp.addMapping("deals","DealID",Deals.class);
	    arp.addMapping("relation","Id1,Id2",Relation.class);
	    arg0.add(arp);
	    //添加数据库 表——model映射
	    _MappingKit.mapping(arp);
	}
	
	/**
	 * 此方法用来配置访问路由，如下代码配置了将 "/hello" 映射到
	 * HelloController这个控制器.
	 * http://localhost/hello  将访问 HelloController.index() 方法
	 * http://localhost/hello/methodName将访问到 HelloController.methodName()方法
	 * Routes.setBaseViewPath(baseViewPath)方法用于为该Routes内部的
	 * 所有Controller设置视图渲染时的基础路径,
	 * 该基础路径与Routes.add(…, viewPath)方法传入的viewPath以及
	 * Controller.render(view) 方法传入的 view 参数联合组成最终的视图路径
	 * finalView = baseViewPath + viewPath + view
	 * 注意：当view以 “/” 字符打头时表示绝对路径，baseViewPath与 viewPath将被忽略
	 */
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.setBaseViewPath("/view");
		arg0.add("/hello", HelloController.class);
	}
	
	// 系统启动完成后回调
	public void afterJFinalStart() {
	}
	 
	// 系统关闭之前回调
	public void beforeJFinalStop() {
	}
}