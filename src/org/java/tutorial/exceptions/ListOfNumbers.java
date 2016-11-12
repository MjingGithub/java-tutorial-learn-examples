package org.java.tutorial.exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2016/11/05
 * @author jing.ming
 *
 */
public class ListOfNumbers {

	private List<Integer> listNumber;
	private static final int SIZE=10 ;
	public ListOfNumbers(){
		listNumber=new ArrayList<Integer>(SIZE) ;
		for(int i=0;i<SIZE;i++){
			listNumber.add(i) ;
		}
	}
	public void writeList() throws IOException,IndexOutOfBoundsException{
		String filePath = "D:"+File.separator+"exception" ;
		File file = new File(filePath) ;
		if(!file.exists()){
			file.mkdirs() ;
		}
		PrintWriter writer = new PrintWriter(new FileWriter(filePath+File.separator+"outfile.txt")) ;
		for(int i=0;i<SIZE;i++){
			writer.println("Value at "+i+"="+listNumber.get(i));
		}
		writer.close() ;
	}
	
	public static void main(String[] args){
		ListOfNumbers list = new ListOfNumbers() ;
		try {
			list.writeList() ;
		} catch (IndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


