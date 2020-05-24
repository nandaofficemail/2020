package i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Publisher implements Runnable {

	Broker broker;

	public Publisher(Broker broker) {
		this.broker = broker;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			broker.put("--"+String.valueOf(i));
		}
		broker.put(null);
		// broker.setFlag(true);
		
		
	}

}
