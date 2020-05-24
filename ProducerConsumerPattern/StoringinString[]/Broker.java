package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Broker {

	ReentrantLock lock = new ReentrantLock();

	Condition notFull = lock.newCondition();

	Condition notEmpty = lock.newCondition();

	String[] storage;

	int current = 0;

	int presentIndex = 0;

	int removedIndex = 0;

	public Broker(int capacity) {
		storage = new String[capacity];
	}

	void put(String string) {
		lock.lock();
		try {
			while (current >= storage.length) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			storage[presentIndex] = string;
			presentIndex = (presentIndex + 1) % storage.length;
			notEmpty.signal();
			++current;
		} finally {
			lock.unlock();
		}
	}

	String get() {
		String object = null;
		lock.lock();
		try {
			while (current <= 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object = storage[removedIndex];
			removedIndex = (removedIndex + 1) % storage.length;
			notFull.signal();
			--current;
		} finally {
			lock.unlock();
		}
		return object;
	}
}
