package org.java.tutorial.nestedClass.lambdaExperssions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author jing.ming
 * @Date 2016/11/05
 *
 */
public class TestPersonLambda {

	public static List<Person> personList = new ArrayList<Person>() ;
	static{
		personList.add(new Person("Liyi", new Date("1993/3/4"), Person.Sex.FEMALE, "3954042@qq.com"));
	}
	public static void printPersonerOlderThan(int age){
		for(Person ps:personList){
			if(ps.getAge()>=age){
				System.out.println(ps.toString());
			}
			
		}
	}
	
	public static void main(String[] args){
		TestPersonLambda.printPersonerOlderThan(10);
		personList.stream().filter(
	        p -> p.getGender() == Person.Sex.FEMALE
	            && p.getAge() >= 18
	            && p.getAge() <= 25)
	    .map(p -> p.getEmailAddress())
	    .forEach(email -> System.out.println(email));
	}
}
