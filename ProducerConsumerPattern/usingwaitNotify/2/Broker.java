package i;

public class Broker {

	String message;

	boolean processState;

	synchronized void put(String string) {
		this.message = string;
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized String get() {
		String object = this.message;
		notify();
		return object;
	}
}
