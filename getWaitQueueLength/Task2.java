package i;

import java.util.concurrent.TimeUnit;
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
		while (true) {
			try {
				if (lock.getWaitQueueLength(condition) == 3) {
					System.err.println("Gooooood" + lock.getWaitQueueLength(condition));
					condition.signal();
				}
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}
		}

	}
}