# spring-cloud
Các ví dụ về Spring Cloud được triển khai trong Spring Boot
- Trang Master chỉ là nhánh rỗng. Mỗi nhánh sẽ đại diện cho 1 project mẫu apply bằng SpringBoot.
- Thông thường thì các commits sẽ đại diện cho các feature nhất định mình cần Demo ...


===============================================================


Tìm hiểu về Spring Cloud Stream 
(kết hợp giữa Spring Integration + Spring Boot + ...)

Refer page : 
	https://docs.spring.io/spring-cloud-stream/docs/3.2.1/reference/html/spring-cloud-stream.html#_a_brief_history_of_springs_data_integration_journey
	https://github.com/spring-cloud/spring-cloud-stream-samples/tree/main/kafka-batch-sample

Tạo 1 ví dụ hỗn hợp sử dụng Spring Cloud Stream
(RabbitMQ + Kafka)

- RabbitMQ:
	- begin-rabbit-topic 	(String message)
	- end-rabbit-topic		(Person message)
- Kafka:
	- start-kafka-topic		(Teacher message)
	- end-kafka-topic		(Teacher2 message)
		
Flow như sau:
- App1: Gửi 7 String message đến `begin-rabbit-topic` bằng RESTful (mannual request):
		http://localhost:9114/send-message
		
- App1: Consume String message từ `begin-rabbit-topic`, 
		sau đó biến đổi thành Person message bằng hàm functionRabbit() 
		rồi đẩy Person message vào `end-rabbit-topic`
		
- App2: Consume Person message từ `end-rabbit-topic` của RabbitMQ,
		sau đó biến đổi thành Teacher message bằng hàm forwardMessageAndConvert()
		rồi đẩy Teacher mesage vào `start-kafka-topic` của Kafka (topic có 5 partitions)
		
- App31: Consume Teacher message từ `start-kafka-topic` với Consumer Group là `group3_ONE`
		và xử lý business logic trong hàm teacherConsumer()
- App32: Nhân bản của App31
- App33: Nhân bản của App31

- App41: Consume Teacher message từ `start-kafka-topic` với Consumer Group là `group4_TWO`
		sau đó biến đổi thành Teacher2 message bằng hàm functionConvertTeacher2()
		rồi đẩy Teacher2 message vào `end-kafka-topic`
- App42: Nhân bản của App41

- App43Consumer: Consume Teacher2 message từ `end-kafka-topic` với Consumer Group là `group4_THREE`
		và xử lý business logic trong hàm consumerTeacher2()
		
		