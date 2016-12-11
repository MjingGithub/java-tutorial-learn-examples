package org.java.tutorial.basicIo.ioStreams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 使用java try-with-resoucrce statement. 捕获异常,凡是实现了java.lang.AutoCloseable或者 java.io.Closeable,都可以被当做一个资源使用try-with-resoure捕获异常.
 * 使用java try-with-resoucrce statement,不管程序正常终止还是异常终止,resource都会关闭.
 * 所有的stream 类信息都是建立在byte stream 之上的.
 * 根据stream要传递的资源类型选择不同的stream处理,可以提高效率.
 * @author jing.ming
 *
 */
public class CopyBytes {
	public static void main(String[] args) {		
		try(FileInputStream input = new FileInputStream("D:/study/git_workSpace/java-tutorial-learn-examples/xanadu.txt") ;
			FileOutputStream output = new FileOutputStream("D:/study/git_workSpace/java-tutorial-learn-examples/outagain.txt")){
			//InputStreamReader reader = new InputStreamReader(input) ;
			int c  ;
			while((c=input.read())!=-1){
				output.write(c);
			}	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	static String readFirstLineFromFile(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	
}
