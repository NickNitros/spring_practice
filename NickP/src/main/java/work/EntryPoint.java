package work;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();
		
		((ConfigurableApplicationContext)ctx).close();
	}

}
