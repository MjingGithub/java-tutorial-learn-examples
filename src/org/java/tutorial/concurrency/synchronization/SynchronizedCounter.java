package org.java.tutorial.concurrency.synchronization;
/**
 * 
 * @ClassName:SynchronizedCounter
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 下午3:33:21
 */
//只需要在可能产生非同步的方法前面加上synchronized关键字,就可以保证方法是同步的.
public class SynchronizedCounter {
	private int c = 0 ;
	public synchronized void increment(){
		c++ ;
	}
	public synchronized void decrement(){
		c-- ;
	}
	public synchronized int value(){
		return c ;
	}
}
