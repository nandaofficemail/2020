package j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Task2 implements Runnable {

	Semaphore semaphore;

	public Task2(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquireUninterruptibly();
			for (int i = 0; i < 30; i++) {
				System.err.println(i);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				semaphore.release();
			}
		} catch (Exception e) {
			System.err.println("Here Exception");
		}
	}
}
