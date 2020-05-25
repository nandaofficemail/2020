package i;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Task t_1ask1 = new Task(lock, condition);
		Task t_1ask2 = new Task(lock, condition);
		Task t_1ask3 = new Task(lock, condition);
		Thread thread_1 = new Thread(t_1ask1);
		Thread thread_2 = new Thread(t_1ask2);
		Thread thread_3 = new Thread(t_1ask3);
		thread_1.start();
		thread_2.start();
		thread_3.start();
		
		Task2 t_1ask4=new Task2(lock, condition);
		Thread thread_4 = new Thread(t_1ask4);
		thread_4.start();
		
	}
}
