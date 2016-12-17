package org.java.tutorial.concurrency.synchronization;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName:SynchronizedStat
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月17日 下午4:34:34
 */
//使用synchronized statement 独立出需要同步访问的代码块
public class SynchronizedStat {

	private String lastName ;
	private int nameCount = 0 ;
	private List<String> addNameList = new ArrayList<String>() ;
	
	public void addName(String name){
		synchronized(this){
			lastName = name ;
			nameCount++ ;
		}
		addNameList.add(name) ;
	}
}
