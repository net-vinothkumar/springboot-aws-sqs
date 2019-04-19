# Spring Boot - AWS SQS

Amazon Simple Queue Service (SQS) is a reliable, scalable, fully-managed message queuing service.

SQS is a distributed queuing system, which gives access to a message queue that you can use to store 
messages while waiting for the end system to process it

### What Is Amazon Simple Queue Service?
Amazon Simple Queue Service (Amazon SQS) offers a secure, durable, and available hosted queue that lets you integrate and decouple distributed software systems and components. 

### When to use SQS ?
SQS is a great way to decouple services, especially when there is a lot of heavy-duty, batch-oriented processing required.
For example, let's say people would like to order food from McDonalds, people use the ordering system, order the food and get the token number, behind the scene the customer order will be processed and delivered once its ready.This entire process is asynchronous and decoupled.


### What Are the Main Benefits of Amazon SQS?
Security – You control who can send messages to and receive messages from an Amazon SQS queue.

Server-side encryption (SSE) lets you transmit sensitive data by protecting the contents of messages in queues using keys managed in AWS Key Management Service (AWS KMS).

Durability – To ensure the safety of your messages, Amazon SQS stores them on multiple servers. Standard queues support at-least-once message delivery, and FIFO queues support exactly-once message processing.

Availability – Amazon SQS uses redundant infrastructure to provide highly-concurrent access to messages and high availability for producing and consuming messages.

Scalability – Amazon SQS can process each buffered request independently, scaling transparently to handle any load increases or spikes without any provisioning instructions.

Reliability – Amazon SQS locks your messages during processing, so that multiple producers can send and multiple consumers can receive messages at the same time.

Customization – Your queues don't have to be exactly alike—for example, you can set a default delay on a queue. You can store the contents of messages larger than 256 KB using Amazon Simple Storage Service (Amazon S3) or Amazon DynamoDB, with Amazon SQS holding a pointer to the Amazon S3 object, or you can split a large message into smaller messages.

There are two types of SQS queues

    Standard and FIFO queues

Standard queues guarantees message delivery at least once.
But if there is a high volume of transactions in a distributed system, messages get delivered more than 
one time, which might cause confusion in the system

In order to avoid this issue, you can opt for FIFO queues
As the name suggests the messages will be delivered First in first out manner
It delivers the message only once
messages are made available only till the consumer processes it, once the consumer processes the message, 
it is deleted this queue mechanism eradicates the duplicate transactions
