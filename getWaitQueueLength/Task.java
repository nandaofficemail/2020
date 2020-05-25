package i;

import java.util.concurrent.TimeUnit;
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
 			//condition.await(5,TimeUnit.SECONDS);
			while (true) {
				System.err.println(Thread.currentThread().getName() + " " + ++i);
				if (i == 2100000) {
					condition.await();
				}
				if (i == 4100000) {
					condition.await();
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