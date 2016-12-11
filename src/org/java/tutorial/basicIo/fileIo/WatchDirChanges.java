package org.java.tutorial.basicIo.fileIo;
/**
 *  The java.nio.file package provides a file change notification API,
 *  called the Watch Service API. This API enables you to register a directory (or directories) 
 *  with the watch service. When registering, you tell the service which types of events 
 *  you are interested in: file creation, file deletion, or file modification. 
 *  When the service detects an event of interest, it is forwarded to the registered process.
 *   The registered process has a thread (or a pool of threads) dedicated to watching for 
 *   any events it has registered for. When an event comes in, it is handled as needed.
 */
/**
 * 
 * @ClassName:WatchDirChanges
 * @Description:监听目录操作
 * @author jing.ming
 * @date 2016年12月10日 下午6:05:10
 */
public class WatchDirChanges {
	//自己实现一个watch service
  /**
	*steps for implements a watch service:
    1. Create a WatchService "watcher" for the file system.
    2.For each directory that you want monitored, register it with the watcher. When registering a directory, you specify the type of events for which you want notification. You receive a WatchKey instance for each directory that you register.
    3.Implement an infinite loop to wait for incoming events. When an event occurs, the key is signaled and placed into the watcher's queue.
    4.Retrieve the key from the watcher's queue. You can obtain the file name from the key.
    5.Retrieve each pending event for the key (there might be multiple events) and process as needed.
    6.Reset the key, and resume waiting for events.
    7.Close the service: The watch service exits when either the thread exits or when it is closed (by invoking its closed method).
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
