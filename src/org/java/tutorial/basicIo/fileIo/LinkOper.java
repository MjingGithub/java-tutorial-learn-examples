package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @ClassName:LinkOper
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月10日 上午11:25:16
 */
public class LinkOper {
//java.nio.file.FileSystemException: D:\study: 客户端没有所需的特权。
	//I don`t know why .
	public static void main(String[] args) {
		//Creating a Symbolic Link
	/*	Path link = Paths.get("D:\\study") ;
		Path target = Paths.get("D:\\symbolicLink") ;
		try {
			Path s = Files.createSymbolicLink(link, target) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//java.nio.file.AccessDeniedException: D:\hardLink -> D:\study 
		//I don`t know why either.
		//Creating a Hard Link
		Path links = Paths.get("D:\\hardLink") ;
		Path existing = Paths.get("D:\\study") ;
		try {
			Files.createLink(links, existing) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断是否是symbolic link
		//boolean isSymbolicLink = Files.isSymbolicLink(file);
		//寻找链接的目标对象
		// Files.readSymbolicLink(link));

	}

}
