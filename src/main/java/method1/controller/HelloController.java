package method1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		
		//会产生一个异常：NumberFormatException
		//然后会将该异常抛给DispatcherServlet,
		//如果DispatcherServlet也不能处理，则会返回给浏览器
		//如果DispathcerServlet配置的有异常处理器，会根据异常处理器的配置进行处理异常
		Integer.parseInt("100a");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2() {
		System.out.println("hello()");
		String str = "adgcbn";
		str.charAt(10);//显然该代码会抛出异常：StringIndexOutOfBoundsException
		return "hello";
	}
}
