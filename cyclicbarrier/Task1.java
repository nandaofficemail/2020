package j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Task1 implements Runnable {

	CyclicBarrier semaphore;

	public Task1(CyclicBarrier semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println(i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Task 1 arrived "+semaphore.await());
			System.out.println("Super Task 1'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
