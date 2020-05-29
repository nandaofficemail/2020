package j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Task3 implements Runnable {

	CyclicBarrier semaphore;

	public Task3(CyclicBarrier semaphore) {
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
			 System.out.println("Task 3 arrived "+semaphore.await());
			System.out.println("Super Task 3'");
		} catch (Exception e) {
			System.err.println("Here Exception");
		}

	}
}
