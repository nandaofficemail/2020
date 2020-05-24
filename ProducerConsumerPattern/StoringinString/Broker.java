package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Broker {

	ReentrantLock lock = new ReentrantLock();

	Condition notFull = lock.newCondition();

	Condition notEmpty = lock.newCondition();

	String message;

	boolean processState;

	void put(String string) {

		lock.lock();
		try {
			while (processState) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.message = string;
			notEmpty.signal();
			processState = true;
		} finally {
			lock.unlock();
		}
	}

	String get() {
		String object;
		lock.lock();
		try {
			while (!processState) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			notFull.signal();
			object = this.message;
			processState = false;
		} finally {
			lock.unlock();
		}
		return object;
	}
}
