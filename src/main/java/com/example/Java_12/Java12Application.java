package com.example.Java_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication

public class Java12Application {


	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
//
//		Practice pr = ctx.getBean(Practice.class);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BeanConfig.class);
		ctx.refresh();

		Practice mb1 = ctx.getBean(Practice.class);
		ctx.close();

	}

}
