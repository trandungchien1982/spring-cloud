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

Sử dụng Avro Schema để mô tả message

=> Build code OK nhưng không chạy được, lỗi UnknownHostException
=> Đã start Docker cho KafkaServer,Kafka Registry và vẫn không connect được

=> Tạm bỏ qua
