package i;

import java.util.concurrent.ThreadFactory;

public class AccessBuilder {

	public static void main(String[] args) {
		
		// One Way
		ThreadFactory customThreadFactory = new
				CustomThreadFactory().setThreadName("A"). setPriority(5).setDaemon(true).
				build();
		
		Thread thread=customThreadFactory.newThread(new U());
		thread.start();
		 
		// Other way
		Customer builder = new Customer().new Builder().setAddress("AA").setAge(34).build();
		System.out.println(builder);

	}
	
}
