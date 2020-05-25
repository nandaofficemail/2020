package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Task t_1ask1 = new Task(lock, condition);
		Task2 t_1ask2 = new Task2(lock, condition);
		Thread thread_1 = new Thread(t_1ask1);
		Thread thread_2 = new Thread(t_1ask2);
		thread_1.start();
		thread_2.start();

	}
}
