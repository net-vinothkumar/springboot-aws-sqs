package com.interviewdot.hotelorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class HotelOrderService {

	private static final Map<Integer, String> FOOD_MENU_MOCK = new HashMap<>();

	static {
		FOOD_MENU_MOCK.put(1, "2 Grand Big Mac");
		FOOD_MENU_MOCK.put(2, "1 Big Mac");
		FOOD_MENU_MOCK.put(3, "4 Mac Jr");
		FOOD_MENU_MOCK.put(4, "3 Big Crunchy Chicken Filet Stripes ");
		FOOD_MENU_MOCK.put(5, "5 Big Crunchy Chicken Filet Stripes ");
		FOOD_MENU_MOCK.put(6, "1 McWrap Chicken");
		FOOD_MENU_MOCK.put(7, "2 Big Tasty Bacon");
		FOOD_MENU_MOCK.put(8, "1 Big Tasty Bacon");
		FOOD_MENU_MOCK.put(9, "5 Chicken Wings");
		FOOD_MENU_MOCK.put(10, "Small Chicken Caesar Salad");
		FOOD_MENU_MOCK.put(11, "1 Big Chicken Caesar Salad");
		FOOD_MENU_MOCK.put(12, "1 Sweet Southern BBQ");
		FOOD_MENU_MOCK.put(13, "3 Double Chicken Burger");
		FOOD_MENU_MOCK.put(14, "2 Raspberry Bag");
		FOOD_MENU_MOCK.put(15, "1 Fries Small");
		FOOD_MENU_MOCK.put(16, "2 Fries Medium");
		FOOD_MENU_MOCK.put(17, "2 Fries Big");
		FOOD_MENU_MOCK.put(18, "2 McSundae caramel");
		FOOD_MENU_MOCK.put(19, "1 MilkShake Strawberry");
		FOOD_MENU_MOCK.put(20, "2 MilkShake Chocolate");
		FOOD_MENU_MOCK.put(21, "2 MilkShake Vanilla");
		FOOD_MENU_MOCK.put(22, "2 Chicken Box");
		FOOD_MENU_MOCK.put(23, "1 Chicken Nuggets");
		FOOD_MENU_MOCK.put(24, "1 Sprite");
		FOOD_MENU_MOCK.put(25, "1 Coke");
		FOOD_MENU_MOCK.put(26, "1 Fanta");
		FOOD_MENU_MOCK.put(27, "1 Chocolate Milkshake");
	}

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndPoint;

	@Scheduled(cron = "0/3 * * * * ?")
	public void sendMessage() {
		Random rand = new Random();
		int foodMenu = rand.nextInt(27);
		queueMessagingTemplate.send(sqsEndPoint, MessageBuilder.withPayload(FOOD_MENU_MOCK.get(foodMenu)).build());
	}
}
