package j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Task1 implements Runnable {

	Semaphore semaphore;

	public Task1(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			for (int i = 0; i < 30; i++) {
				System.out.println(i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
