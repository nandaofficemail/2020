1)   while(!future.isDone()){
		TimeUnit.Seconds.Sleep(2);
     } 
    
    while(!future.getDelay(5,TimeUnit.Seconds) <-5); // This is helpful to run the Threads only for 5 seconds.
    
    
2)  while(!executor.isTerminated());
    Sysout("Finished All Threads");
    
    if(!executor.isShutdown()){
        executor.shutdown();
    }
    
3)   // To interrupt the thread
     while(!Thread.interrupted()){
     
     }
     while(Thread.currentThread().interrupt()){
     
     }
	 
	 
4)   ThreadFactory threadFactory=Executors.defualtThreadFactory();
	 for(int i=0;i<3;i++){
		 Thread d=threadFactory.newThread(new Task());
		 d.start();
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

5) 
All you have to do is maintain a list of Futures that you submit, and then you can iterate over the whole list of Futures and either:
  A) wait for all the futures to be done in a blocking way or
  B) check if all the futures are done in a non-blocking way.

Here is a code example:

List<Future<?>> futures = new ArrayList<Future<?>>();
ExecutorService exec = Executors.newFixedThreadPool(5);

// Instead of using exec.execute() use exec.submit()
// because it returns a monitorable future
while((item = stack.pollFirst()) != null){
    Runnable worker = new Solider(this, item);
    Future<?> f = exec.submit(worker);
    futures.add(f);
}

// A) Await all runnables to be done (blocking)
for(Future<?> future : futures)
    future.get(); // get will block until the future is done

// B) Check if all runnables are done (non-blocking)
boolean allDone = true;
for(Future<?> future : futures){
    allDone &= future.isDone(); // check if future is done
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
6)