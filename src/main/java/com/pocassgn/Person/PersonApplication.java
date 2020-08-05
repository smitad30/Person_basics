package com.pocassgn.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class PersonApplication implements CommandLineRunner {
    
	@Autowired
	  YamlToJson yj;
	
	@Autowired
	 PersonController pc;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
		
	}
	

@Override
public void run(String... args) throws Exception {
	yj.convertYamlToJson();
	pc.convertYamlToJson_validateSchema();
	
} 
}
