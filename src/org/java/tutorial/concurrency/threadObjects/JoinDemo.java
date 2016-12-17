package org.java.tutorial.concurrency.threadObjects;
/*
主线程向下转时，碰到了a.join(),a要申请加入到运行中来，就是要CPU执行权。这时候CPU执行权在主线程手里，主线程就把CPU执行权给放开，
 陷入冻结状态。活着的只有a了，只有当a拿着执行权把这些数据都打印完了，主线程才恢复到运行中来。
join方法可以用于临时加入线程，一个线程在运算过程中，如果满足于条件，我们可以临时加入一个线程，让这个线程运算完，
另外一个线程再继续运行。
如果将a.join()和b.start()位置互换，又会怎样呢？主线程开启了a、b，这时候CPU执行权还在主线程手里。
当主线程碰到了a.join(),释放执行权，处于冻结状态。活着的a、b都具备执行资格，这时候CPU便对a和b交替执行。
主线程要等到a结束才能活，至于b结不结束，与主线程没有丝毫关系。如果a结束了，b还没结束，主线程就会和b抢执行权执行。
主线程碰到谁的join，它就等谁。也就是说，谁让它把执行权放出来，它就等谁死。至于谁去抢，它不管。
 */
/**
 * 
 * @ClassName:JoinDemo
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 上午11:50:57
 */
public class JoinDemo implements Runnable{

	@Override
	public void run() {
		for(int x=1; x<100; x++)
			System.out.println(Thread.currentThread().getName() + "..."+x);
	
	}
	
	public static void main(String[] args) {
		JoinDemo d = new JoinDemo() ;
		Thread a = new Thread(d,"a") ;
		Thread b = new Thread(d,"b") ;
		
		a.start();
		try {
			a.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.start();
		for(int x=1; x<100; x++)
			System.out.println(Thread.currentThread().getName() + "..."+x);

	}

}
