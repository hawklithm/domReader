package org.hawklithm.domReader.main;

import org.hawklithm.domReader.reader.JavaReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		JavaReader reader=(JavaReader) context.getBean("reader");
		System.out.println("root folder is :"+args[0]);
		reader.readFolder(args[0]);
//		HelloTest obj = (HelloTest) context.getBean("helloBean");
//		obj.sayHello();
	}
}