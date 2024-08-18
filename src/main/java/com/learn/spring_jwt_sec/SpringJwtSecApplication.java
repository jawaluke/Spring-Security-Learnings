package com.learn.spring_jwt_sec;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringJwtSecApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJwtSecApplication.class, args);
		log.info("Beans : {}", List.of(applicationContext.getBeanDefinitionNames()));
	}

}
