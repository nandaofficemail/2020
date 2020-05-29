package j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Task2 implements Runnable {

	CyclicBarrier semaphore;

	public Task2(CyclicBarrier semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 30; i++) {
				System.err.println(i);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			semaphore.await();
			System.out.println("Task 2 arrived "+semaphore.await());
			System.out.println("Super Task 2'");
		} catch (Exception e) {
			System.err.println("Here Exception");
		}
	}
}
