package com.stackroute.asyncprogrammingMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncprogrammingMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncprogrammingMysqlApplication.class, args);
	}

}
