package i;

import java.util.HashSet;

public class Subscriber implements Runnable {

	Broker broker;

	public Subscriber(Broker broker) {
		this.broker = broker;
	}

	@Override
	public void run() {
		HashSet<String> hashSet = new HashSet<>();
		do {
			String object = broker.get();
			if (object == null)
				break;
			if (!hashSet.contains(object)) {
				hashSet.add(object);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Object Received " + object);
			}

		} while (true);

		/*for (int i = 0; i < 10; i++) {
			System.out.println(broker.get());
		}
		
		while(!broker.isFlag()) {
			System.out.println(broker.get());
		}*/

	}
}
