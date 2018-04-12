package method2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.ApplicationException;

@Controller
public class HelloController {

	
	/**
	 * 异常处理方法：
	 * 使用@ExceptionHandler注解配置:
	 * 在该方法里面，依据异常类型，分别进行不同的处理。
	 * @param ex是其他方法所抛出的异常
	 * @return
	 */
	@ExceptionHandler
	public String exHandle(Exception ex, HttpServletRequest request) {
		
		if(ex instanceof NumberFormatException) {
			request.setAttribute("errorMessage", "亲，请输入正确的数字");
			
			//默认转发到error界面
			return "error";
		}else if(ex instanceof ApplicationException) {
			request.setAttribute("errorMessage", ex.getMessage());
			return "error";
		}else if(ex instanceof StringIndexOutOfBoundsException) {
			request.setAttribute("errorMessage", "亲，下标越界");
			return "error";
		}else {
			request.setAttribute("errorMessage", "系统繁忙，请稍后重试");
			return "error";
			
		}
	}
	
	@RequestMapping("/hello.form")
	public String hello() {
		System.out.println("hello()");
		
		//会产生一个异常：NumberFormatException
		//然后会将该异常抛给DispatcherServlet,
		//如果DispatcherServlet也不能处理，则会返回给浏览器
		//如果DispathcerServlet配置的有异常处理器，会根据异常处理器的配置进行处理异常
		Integer.parseInt("100a");
		return "hello";
	}
	
	@RequestMapping("/hello2.form")
	public String hello2() {
		System.out.println("hello2()");
		String str = "adgcbn";
		str.charAt(10);//显然该代码会抛出异常：StringIndexOutOfBoundsException
		return "hello";
	}
	@RequestMapping("/hello3.form")
	public String hello3() {
		System.out.println("hello3()");
		
	
			
			throw new ApplicationException("异常消息");
		
		
	
	}
	
	
}
