package org.java.tutorial.nestedClass;
/**
 * 
 * @author jing.ming
 * @Date 2016/11/05
 */
public class OuterClass {
	
	
	//inner class 有进入外部类的所有成员方法的权限,即使外部类的某些成员声明为private的
	//但是因为inner class是外部类的实例成员.所以不能在内部声明静态成员,使用时也必须先实例化外部类对象.
	class InnerClass{
		
	}
	//static nest classes 没有访问外部类的权限
	static class StaticNestedClass{
		
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass() ;
		OuterClass.InnerClass oi = oc.new InnerClass() ;
		OuterClass.StaticNestedClass os = new OuterClass.StaticNestedClass() ;
	}

}
