package i;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory {

	private String threadName;

	private Integer priority;

	private Boolean daemon;

	public CustomThreadFactory setDaemon(Boolean daemon) {
		this.daemon = daemon;
		return this;
	}

	public CustomThreadFactory setPriority(Integer priority) {
		this.priority = priority;
		return this;
	}

	public CustomThreadFactory setThreadName(String threadName) {
		this.threadName = threadName;
		return this;
	}

	private Boolean getDaemon() {
		return daemon;
	}

	private Integer getPriority() {
		return priority;
	}

	private String getThreadName() {
		return threadName;
	}

	ThreadFactory build() {
		return build(this);
	}

	private ThreadFactory build(CustomThreadFactory customThreadFactory) {
		ThreadFactory factory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName(customThreadFactory.getThreadName());
				thread.setDaemon(customThreadFactory.getDaemon());
				thread.setPriority(customThreadFactory.getPriority());
				return thread;
			}
		};
		return factory;
	}

}
