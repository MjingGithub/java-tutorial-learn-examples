package org.java.tutorial.basicIo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 一行一行的读取
 * CopyLines outputs each line using println, which appends the line terminator for the current operating system.
 * This might not be the same line terminator that was used in the input file.
 * @author jing.ming
 *
 */
public class CopyLines {

	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new FileReader("D:/study/git_workSpace/java-tutorial-learn-examples/xanadu.txt"));
			PrintWriter writer = new PrintWriter(new FileWriter("D:/study/git_workSpace/java-tutorial-learn-examples/lineOriented.txt"))	){
			String l;
            while ((l = reader.readLine()) != null) {
            	writer.println(l);
            }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
