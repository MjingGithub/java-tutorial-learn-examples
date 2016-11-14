package org.java.tutorial.basicIo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {

	public static void main(String[] args) {
		double sum = 0 ;
		try(Scanner s = new Scanner(new BufferedReader(new FileReader("D:/study/git_workSpace/java-tutorial-learn-examples/usnumbers.txt")))){
			s.useLocale(Locale.CHINA) ;
			while(s.hasNext()){
				if(s.hasNextDouble()){
					sum+=s.nextDouble() ;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sum:"+sum);
	}

}
