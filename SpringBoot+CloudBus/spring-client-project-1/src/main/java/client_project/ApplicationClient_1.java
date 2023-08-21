package client_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ApplicationClient_1 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient_1.class, args);
    }    
}
