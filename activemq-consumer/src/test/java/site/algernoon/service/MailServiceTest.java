package site.algernoon.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailServiceTest {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "classpath:spring-context.xml" });
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
