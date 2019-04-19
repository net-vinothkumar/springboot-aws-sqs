package com.interviewdot.hotelkitchen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class HotelKitchenProcessor {

	private static final Logger LOG = LoggerFactory.getLogger(HotelKitchenProcessor.class);

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndPoint;

	@SqsListener("springboot-sqs")
	public void getMessage(String message) {
		LOG.info("Message from SQS Queue - **************************\n"+
				message
		+ "\n **************************");
	}
}
