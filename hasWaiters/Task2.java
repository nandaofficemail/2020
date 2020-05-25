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
		int i = 0;
		while (i < 5) {
			try {
				i++;
				if (lock.hasWaiters(condition)) {
					System.err.println("Gooooood" + lock.getWaitQueueLength(condition));
				}
			} catch (Exception e) {
				
			}
		}
		try {
			TimeUnit.SECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}
}