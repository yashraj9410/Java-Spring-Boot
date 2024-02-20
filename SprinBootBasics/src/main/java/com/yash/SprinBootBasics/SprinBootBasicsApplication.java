package com.yash.SprinBootBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprinBootBasicsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SprinBootBasicsApplication.class, args);

		Alien obj = context.getBean(Alien.class);
		obj.run_code();
		System.out.println(obj.getAge());

	}

}
