package work;

public class Juggler implements Performer {
	
	private int beanBags = 3;
	private String name;

	public Juggler() {
	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public int getBeanBags() {
		return beanBags;
	}

	public String getName() {
		return name;
	}

	public void goSleep() {
		System.out.println("Rest for juggling.");
	}

	public void perform() {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

	public void setBeanBags(int beanBags) {
		this.beanBags = beanBags;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void wakeUp() {
		System.out.println("Woke up to juggle.");
	}
}
