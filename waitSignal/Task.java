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
			lock.lock();
			System.out.println("Task has got the lock");
			while (true) {
				System.err.println(Thread.currentThread().getName() + " " + ++i);
				if (i == 2100000) {
					condition.await();
					System.err.println("Gor signal" + Thread.currentThread().getName());
				}
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