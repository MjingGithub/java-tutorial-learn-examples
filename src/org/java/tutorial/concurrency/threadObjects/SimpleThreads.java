package org.java.tutorial.concurrency.threadObjects;
/**
 * 
 * @ClassName:SimpleThreads
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 下午2:17:21
 */
public class SimpleThreads {
	static void threadMessages(String message){
		String name = Thread.currentThread().getName()  ;
		System.out.println("current thread is:"+name+",mesasge:"+message) ;
	}
	
	private static class LoopMessage implements Runnable{

		@Override
		public void run() {
			String[] processInfo = {"Morning I wake up","brush teeth,clean face","eat breakfast","dress up,make up"} ;
			for(int i=0;i<processInfo.length;i++){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					threadMessages("I wasn't done!");
					//e.printStackTrace();
				}
				threadMessages(processInfo[i]) ;
			}
			
		}
		
	}

	public static void main(String[] args) {
		long patience = 3000;//1000*60*60 ;//default 1 hour
		threadMessages("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new LoopMessage());
        t.start();

        threadMessages("Waiting for MessageLoop thread to finish");
       // loop until MessageLoop thread exits
        while (t.isAlive()) {
            threadMessages("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            try {
				t.join(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
                threadMessages("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        threadMessages("Finally!");
		
	}

}
