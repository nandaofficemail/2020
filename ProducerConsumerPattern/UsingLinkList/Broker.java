package i;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Broker {

	Queue<String> queue;

	int capacity;

	ReentrantLock lock = new ReentrantLock();

	Condition notFull = lock.newCondition();

	Condition notEmpty = lock.newCondition();
	
	boolean flag;
	
	public Broker(int capacity) {
		this.capacity = capacity;
		queue = new LinkedList<String>();
	}

	void put(String string) {
		lock.lock();
		try {
			if (queue.size() == capacity) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.add(string);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	String get() {
		lock.lock();
		String object = null;
		try {
			if (queue.size() == 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object = queue.poll();
			notFull.signal();
		} finally {
			lock.unlock();
		}
		return object;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isFlag() {
		return flag;
	}
}
