package com.example.lxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;



@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.lxk.mapper") 
public class LxkApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(LxkApplication.class, args);
	}

}
