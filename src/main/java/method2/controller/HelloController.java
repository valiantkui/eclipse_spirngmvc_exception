package method2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.ApplicationException;

@Controller
public class HelloController {

	
	/**
	 * �쳣��������
	 * ʹ��@ExceptionHandlerע������:
	 * �ڸ÷������棬�����쳣���ͣ��ֱ���в�ͬ�Ĵ���
	 * @param ex�������������׳����쳣
	 * @return
	 */
	@ExceptionHandler
	public String exHandle(Exception ex, HttpServletRequest request) {
		
		if(ex instanceof NumberFormatException) {
			request.setAttribute("errorMessage", "�ף���������ȷ������");
			
			//Ĭ��ת����error����
			return "error";
		}else if(ex instanceof ApplicationException) {
			request.setAttribute("errorMessage", ex.getMessage());
			return "error";
		}else if(ex instanceof StringIndexOutOfBoundsException) {
			request.setAttribute("errorMessage", "�ף��±�Խ��");
			return "error";
		}else {
			request.setAttribute("errorMessage", "ϵͳ��æ�����Ժ�����");
			return "error";
			
		}
	}
	
	@RequestMapping("/hello.form")
	public String hello() {
		System.out.println("hello()");
		
		//�����һ���쳣��NumberFormatException
		//Ȼ��Ὣ���쳣�׸�DispatcherServlet,
		//���DispatcherServletҲ���ܴ�����᷵�ظ������
		//���DispathcerServlet���õ����쳣��������������쳣�����������ý��д����쳣
		Integer.parseInt("100a");
		return "hello";
	}
	
	@RequestMapping("/hello2.form")
	public String hello2() {
		System.out.println("hello2()");
		String str = "adgcbn";
		str.charAt(10);//��Ȼ�ô�����׳��쳣��StringIndexOutOfBoundsException
		return "hello";
	}
	@RequestMapping("/hello3.form")
	public String hello3() {
		System.out.println("hello3()");
		
	
			
			throw new ApplicationException("�쳣��Ϣ");
		
		
	
	}
	
	
}
