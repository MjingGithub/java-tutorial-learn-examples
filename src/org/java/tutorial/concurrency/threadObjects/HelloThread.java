package org.java.tutorial.concurrency.threadObjects;
/**
 * 
 * @ClassName:HelloThread
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 上午10:13:43
 */
//创建Thread实例之二:继承Thread.覆盖Thread对象的run方法.
public class HelloThread extends Thread{
	
	public void run(){
		System.out.println("Hello from a thread!");
	}

	public static void main(String[] args) {
		(new HelloThread()).start();

	}

}
