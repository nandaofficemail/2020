package j;

import java.util.concurrent.Semaphore;

public class Seeema {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		Task1 task1 = new Task1(semaphore);
		Task2 task2 = new Task2(semaphore);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		thread1.start();

		//
		thread2.start();

	}
}
