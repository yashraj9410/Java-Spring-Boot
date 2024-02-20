package com.yash.SprinBootBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprinBootBasicsApplication {

	public static void main(String[] args) {

		// activates my spring framework
		// object created by spring are called beans
		ApplicationContext context = SpringApplication.run(SprinBootBasicsApplication.class, args); // running the container
		System.out.println("Hello");

		Alien obj  = context.getBean(Alien.class);  // how can i ask spring to add obj in Container

		// we can use Application Context to fetch the obj in the container
		obj.code();
	}

}
