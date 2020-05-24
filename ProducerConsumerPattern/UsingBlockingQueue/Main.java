package h;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Points to Note
// 1) Queue will Block if the elements cant be put in , if the queue is full 
// 2) On the same page , queue will block if the queue is empty

public class Main {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(Byte.MAX_VALUE);
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (i < Byte.MAX_VALUE) {
					try {
						blockingQueue.put(String.valueOf(i));
						++i;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < Byte.MAX_VALUE; i++) {
					System.err.println(blockingQueue.poll());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}