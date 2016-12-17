package org.java.tutorial.concurrency.synchronization;
/**
 * 
 * @ClassName:LockDemo
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 下午4:31:42
 */
//当2个进程分开互不影响,可以使用lock,分别用各自的锁控制各自的线程访问.
//一个线程不能获取到另外一个线程控制的锁.但是一个线程可以获取到它本身已经拥有的锁.
//允许一个线程多次获取同一个锁就是 reentrant synchronization
//This describes a situation where synchronized code, directly or indirectly,
//invokes a method that also contains synchronized code, and both sets of code use the same lock
public class LockDemo {

	private long c1 =  0 ;
	private long c2 = 0 ;
	private Object lock1 = new Object() ;
	private Object lock2 = new Object() ;
	
	public void inc1(){
		synchronized (lock1) {
			c1++ ;
		}
	}
	
	public void inc2(){
		synchronized (lock2) {
			c2++ ;
		}
	}
	
}
