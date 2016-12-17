package org.java.tutorial.concurrency.threadObjects;
/**
 * 
 * @ClassName:HelloRunnable
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 上午10:01:51
 */
//创建Thread实例之一:提供一个Runnable对象.Runnable接口定义了一个唯一的run方法,意味着在run方法中写线程执行的代码.
//Runnable对象会被传递给Thread构造函数.
//一般我们选择使用该方法创建一个Thread对象,因为第一种方法中,Runnable对象可以继承自己定义的线程类而第二种只能是Thread子类.
public class HelloRunnable implements Runnable{

	public static void main(String[] args) {
		(new Thread(new HelloRunnable(), "helloThread")).start(); 

	}

	@Override
	public void run() {
		System.out.println("Hello from a thread.");
		
	}

}
