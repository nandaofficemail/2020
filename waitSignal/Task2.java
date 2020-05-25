package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task2 implements Runnable {

	ReentrantLock lock;

	Condition condition;

	public Task2(ReentrantLock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		lock.lock();
		while(lock.getWaitQueueLength(condition)==1) {
			System.err.println("i am about to release lock  for thread 1");
			condition.signal();
			lock.unlock();
		}
	}

}
