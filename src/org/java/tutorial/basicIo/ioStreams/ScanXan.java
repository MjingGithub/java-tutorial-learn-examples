package org.java.tutorial.basicIo.ioStreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * 
 * @author jing.ming
 *
 */
public class ScanXan {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(new BufferedReader(new FileReader("D:/study/git_workSpace/java-tutorial-learn-examples/xanadu.txt")))){
			//s.useDelimiter(",\\s*");
			//默认是以空白分割,可以指定分割符号
			while(s.hasNext()){
				System.out.println(s.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
