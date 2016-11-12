package org.java.tutorial.nestedClass;

import java.net.URLDecoder;

/**
 * 
 * @author jing.ming
 * @Date 2016/11/05
 * anonymous class
 * They enable you to declare and instantiate a class at the same time. 
 * They are like local classes except that they do not have a name.
 *  Use them if you need to use a local class only once.
 */
public class HelloWorldAnonymousClasses {
	interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
  
    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
      
        HelloWorld englishGreeting = new EnglishGreeting();
        //the instantiation of the frenchGreeting object
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
        
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp =
            new HelloWorldAnonymousClasses();
        myApp.sayHello();
     /*  String url =  "checkUser('%7B%22ret%22%3A%221%22%2C%22u%22%3A%22jing.ming%22%2C%22l%22%3A%22http%3A%2F%2Fwww.openportal.com.cn%22%2C%22msg%22%3A%22%E8%AE%A4%E8%AF%81%E5%A4%B1%E8%B4%A5%EF%BC%81%22%2C%22i%22%3A%2210.13.1.50%22%7D')";
       String decodeUtrl = URLDecoder.decode(url) ;
       System.out.println(decodeUtrl);*/
    }            

}
