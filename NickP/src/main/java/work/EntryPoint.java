package work;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-idol.xml");

		Juggler performer = (Juggler) ctx.getBean("juggler");
		performer.perform();

		System.out.println(performer.getName());

		((ConfigurableApplicationContext) ctx).close();
	}

}
