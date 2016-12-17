package org.java.tutorial.concurrency.synchronization;
/**
 * 
 * @ClassName:Counter
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 下午2:53:34
 */
public class Counter {

	private int c = 0 ;
	public void increment(){
		c++ ;
	}
	public void decrement(){
		c-- ;
	}
	public int value(){
		return c ;
	}
}
