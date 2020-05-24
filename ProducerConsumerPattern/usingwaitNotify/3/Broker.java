package i;

public class Broker {

	String message;

	boolean processState;

	void put(String string) {
		try {
			synchronized (this) {
				this.message = string;
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	String get() {
		String object = null;
		synchronized (this) {
			object = this.message;
			notify();
			return object;
		}

	}
}
