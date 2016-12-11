package org.java.tutorial.basicIo.ioStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * character streams
 * @author jing.ming
 * notice:in CopyCharacters, the int variable holds a character value in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits.
 */
public class CopyCharacters {

	public static void main(String[] args) {
		try(FileReader input = new FileReader("D:/study/git_workSpace/java-tutorial-learn-examples/xanadu.txt") ;
				FileWriter output = new FileWriter("D:/study/git_workSpace/java-tutorial-learn-examples/characteroutagain.txt")){
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

}
