package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.bank.dao")
public class Main {
	public static void main(String[] args) {
		/*SpringApplication bootstrap=new SpringApplication(Main.class);
    	bootstrap.run(args);*/
		SpringApplication.run(Main.class, args); 
	}

}
