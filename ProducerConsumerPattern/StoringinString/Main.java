package f;

public class Main {

	public static void main(String[] args) {
		MyOwnQueue myOwnQueue=new MyOwnQueue(11);
		Thread thread1=new Thread(new Publisher(myOwnQueue));
		Thread thread2=new Thread(new Subscriber(myOwnQueue));
		thread1.start();
		
		thread2.start();
	}
}
