package method1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		
		//�����һ���쳣��NumberFormatException
		//Ȼ��Ὣ���쳣�׸�DispatcherServlet,
		//���DispatcherServletҲ���ܴ�����᷵�ظ������
		//���DispathcerServlet���õ����쳣��������������쳣�����������ý��д����쳣
		Integer.parseInt("100a");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2() {
		System.out.println("hello()");
		String str = "adgcbn";
		str.charAt(10);//��Ȼ�ô�����׳��쳣��StringIndexOutOfBoundsException
		return "hello";
	}
}
