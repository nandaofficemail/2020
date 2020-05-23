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
     while(Thread.currentThread().isinterrupted()){
     
     }

     
