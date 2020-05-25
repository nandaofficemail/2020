package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {

	ReentrantLock lock;

	Condition condition;

	public Task(ReentrantLock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		int i = 0;

		try {
			lock.lockInterruptibly();
			System.out.println("Task has got the lock");
			while (true) {
				System.err.println(Thread.currentThread().getName() + " " + ++i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}

		}
	}

}