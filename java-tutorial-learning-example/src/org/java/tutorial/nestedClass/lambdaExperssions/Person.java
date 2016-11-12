package org.java.tutorial.nestedClass.lambdaExperssions;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author jing.ming
 * @Date 2016/11/05
 */
public class Person implements Serializable{
	private static final long serialVersionUID = 6684225426838793458L;

	public enum Sex{
		MALE,FEMALE
	}
	private String name ;
	private Date birthday ;
	private Sex gender ;
	private String emailAddress ;
	
	public int getAge(){
		Date now = new Date();
		return now.getYear()-birthday.getYear() ;
	}
	public Person(String name,Date birthday,Sex gender,String emailAddress){
		this.name = name;
		this.birthday = birthday ;
		this.gender = gender ;
		this.emailAddress = emailAddress ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String  toString(){
		String str = "[name:"+this.getName()+",age:"+this.getAge()+",gender:"+this.getGender()+",emailAddress:"+this.emailAddress+"]";
		return str ;
		
	}
}
