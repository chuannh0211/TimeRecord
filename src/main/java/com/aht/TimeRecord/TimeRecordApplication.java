package com.aht.TimeRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aht")
public class TimeRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeRecordApplication.class, args);

	}

}
