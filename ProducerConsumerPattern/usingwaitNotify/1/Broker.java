package i;

public class Broker {

	Object notFull = new Object();

	Object notEmpty = new Object();

	String message;

	boolean processState;

	synchronized void put(String string) {
		try {
			while (processState) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.message = string;
			notify();
			processState = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	synchronized String get() {
		String object = null;
		try {
			while (!processState) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			notify();
			object = this.message;
			processState = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
