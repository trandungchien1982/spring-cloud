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

Nắm các khái niệm cơ bản trong Spring Cloud Stream
	- Destination Binder: 
		Gắn chặt & kết nối với các message broker tự động :
		(dựa trên dependencies sử dụng trong Spring Boot)
			+ RabbitMQ
			+ Kafka
	- StreamBridge/Consumer/Function/...
	
Trong ví dụ này:
	- Khởi chạy app Spring Boot, kích hoạt runner(), tạo 7 messages và gửi đến topic `batch-in-topic`
	- Hàm bindingKafka() consume các messages trên, chuyển đổi message sang UPPERCASE và gửi tiếp đến topic `batch-out-topic`
	- Hàm listen() consume các messages từ topic `batch-out-topic` và in ra Console Log
