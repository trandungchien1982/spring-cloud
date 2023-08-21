# spring-cloud
Các ví dụ về Spring Cloud được triển khai trong Spring Boot
- Trang Master chỉ là nhánh rỗng. Mỗi nhánh sẽ đại diện cho 1 project mẫu apply bằng SpringBoot.
- Thông thường thì các commits sẽ đại diện cho các feature nhất định mình cần Demo ...


===============================================================

Example all related to Spring Boot + ConfigServer + Cloud Bus
Refer page : 
	https://www.baeldung.com/spring-cloud-configuration
	https://spring.io/guides/gs/centralized-configuration/


Config Server:
	http://localhost:8888


Homepage:
	http://localhost:9005/index.html


Clients :
	http://localhost:9005/normal01
	http://localhost:9005/normal02
	
Vi config co' van de nen tam thoi examples ko work duoc nhu mong muon.
	- Tat ca cac service deu start len duoc.
	- Moi khi edit file Config Properties thi cac ConfigServer co' thay doi & fire events den RabbitMQ.
		Tuy nhien ko co' update keys moi khi thong bao message
	- Ca'c clients deu call /refresh tu dong, tuy nhien ko thay message moi (NOT EXPECTED)
