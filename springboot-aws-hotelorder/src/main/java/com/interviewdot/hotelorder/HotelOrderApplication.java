package com.interviewdot.hotelorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HotelOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelOrderApplication.class, args);
	}
}
