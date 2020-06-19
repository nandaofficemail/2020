package some;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
	
	public static void main(String[] args) {
		DelyedTask delyedTask2 = new DelyedTask("B", 1000);
		DelyedTask delyedTask1 = new DelyedTask("A", 3000);
		DelyedTask delyedTask3 = new DelyedTask("C", 500);
		DelyedTask delyedTask4 = new DelyedTask("D", 100);
		DelyedTask delyedTask5 = new DelyedTask("R", 10000);
		DelayQueue<Delayed> delayeds = new DelayQueue<>();
		delayeds.add(delyedTask1);
		delayeds.add(delyedTask2);
		delayeds.add(delyedTask3);
		delayeds.add(delyedTask4);
		delayeds.add(delyedTask5);

		try {
			DelyedTask delyedTask = (DelyedTask) delayeds.take();
			while (delyedTask != null) {
				System.out.println(delyedTask.name);
				if (delayeds.size() > 0)
					delyedTask = (DelyedTask) delayeds.take();
				else
					delyedTask = null;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class DelyedTask implements Delayed {

	long delayTime;

	String name;

	public DelyedTask(String name, long d) {
		this.name = name;
		this.delayTime = System.currentTimeMillis() + d;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = this.delayTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		DelyedTask delyedTask = (DelyedTask) o;
		if (delyedTask.delayTime > this.delayTime)
			return -1;
		if (delyedTask.delayTime < this.delayTime)
			return 1;
		return 0;
	}
}