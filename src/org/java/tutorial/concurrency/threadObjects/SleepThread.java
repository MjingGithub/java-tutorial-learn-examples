package org.java.tutorial.concurrency.threadObjects;
/**
 * 
 * @ClassName:SleepThread
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 上午10:25:50
 */
public class SleepThread {

	public static void main(String[] args) {


		String[] processInfo = {"Morning I wake up","brush teeth,clean face","eat breakfast","dress up,make up"} ;

		for(int i=0;i<processInfo.length;i++){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return ;
			}//暂停4s
			System.out.println(processInfo[i]) ;
		}
	}

}
