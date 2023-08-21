package configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigServer
public class ApplicationConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigServer.class, args);
    }
}
