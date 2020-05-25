package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Task t_1ask = new Task(lock, condition);
		Task2 t2 = new Task2(lock, condition);
		Thread thread_1 = new Thread(t_1ask);
		Thread thread_2 = new Thread(t2);
		thread_1.start();
		thread_2.start();
	}
}
