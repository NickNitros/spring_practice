package work;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-idol.xml");

		Juggler performer = (Juggler) ctx.getBean("juggler");
		performer.perform();

		System.out.println(performer.getName());
		
		List<City> testList = (List<City>) ctx.getBean("cities");
		for(City c : testList) {
			//City fromList = (City)c;
			System.out.println(c.getName());
		}

		((ConfigurableApplicationContext) ctx).close();
	}

}
