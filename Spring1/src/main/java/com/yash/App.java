package com.yash;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        // after adding the spring dependency we can use the application context
        // the below line creates a context for me to inject the object
        // now we use getBean that picks up the object and places it in the container

        // spring.xml is the container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // path of config
        Alien obj = (Alien) context.getBean("alien");
        // typecasting to tell bean that we want obj of type Alien

        // we need to make a communication also
        // create a xml file in class path
        obj.code();
        System.out.println( "Hello World!" );
    }
}
