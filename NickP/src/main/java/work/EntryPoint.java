package work;

import java.util.List;

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
		
		List testList = (List) ctx.getBean("cities");
		for(Object c : testList) {
			City fromList = (City)c;
			System.out.println(fromList.getName());
		}

		((ConfigurableApplicationContext) ctx).close();
	}

}
