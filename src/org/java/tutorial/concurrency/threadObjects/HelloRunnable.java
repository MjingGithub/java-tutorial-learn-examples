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
		Thread thred = new Thread(new HelloRunnable(), "helloThread") ;
		thred.start(); 
		//activeCount:2
		System.out.println("activeCount:"+Thread.activeCount()) ;
		// toString( name, priority,thread group).
		System.out.println("currentThread:"+Thread.currentThread().toString());//输出Thread[main,5,main]
		//checkAccess
		thred.checkAccess() ;
		//getContextClassLoader
		//Returns the context ClassLoader for this Thread
		ClassLoader classLoader = thred.getContextClassLoader() ;
		System.out.println(classLoader.toString());//输出sun.misc.Launcher$AppClassLoader@73d16e93
		//dumpStack
		//Thread.dumpStack();
		//getState()
		System.out.println("getState:"+thred.getState().toString());//如果是thred输出是TERMINATED,如果是当前线程因为是main线程,就会是RUNNABLE
		//getThreadGroup()
	//	System.out.println(thred.getThreadGroup().toString());//如果是已经终结的线程,会返回null.
		//System.out.println(Thread.currentThread().getThreadGroup().toString());//主线程输出:java.lang.ThreadGroup[name=main,maxpri=10]
	long val = Long.parseLong("9223372036854775809");
	System.out.println(val); 
	}

	@Override
	public void run() {
		System.out.println("Hello from a thread.");
		
	}

}
