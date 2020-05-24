package i;

public class Main {

	public static void main(String[] args) {
		Broker broker = new Broker(10);
		Thread threadOne = new Thread(new Publisher(broker));
		Thread threadTwo = new Thread(new Subscriber(broker));
		threadOne.start();
		threadTwo.start();
	}
}
