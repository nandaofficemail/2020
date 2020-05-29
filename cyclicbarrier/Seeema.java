package j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Seeema {

	public static void main(String[] args) {
		CyclicBarrier semaphore = new CyclicBarrier(3, () -> {
			for (int i = 0; i < Byte.MAX_VALUE; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println("Hey Babay" + i);
			}
		});
		Task1 task1 = new Task1(semaphore);
		Task2 task2 = new Task2(semaphore);
		Task3 task3 = new Task3(semaphore);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		thread1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		// thread1.interrupt();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread3.start();

		System.out.println("alllllllllllllllllllllll");
	}
}
