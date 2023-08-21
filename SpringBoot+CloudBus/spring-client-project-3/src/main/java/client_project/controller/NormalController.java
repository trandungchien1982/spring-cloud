package client_project.controller;

//import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

@RestController
public class NormalController {
	@Value("${value01}")
    private String value01;

	@Value("${value02}")
    private String value02;
	
    @GetMapping("/normal01")
    public String test01() {
    	return "<br/>In Client 3 - NormalController :: <br/>Value 01 : " + value01;
    }
    @GetMapping("/normal02")
    public String test02() {
    	return "<br/>In Client 3 - NormalController :: <br/>Value 02 : " + value02;
    }
    
//    @GetMapping("/call-refresh-config")
//    public String call_refresh_config() {
//    	RestTemplate restTemplate = new RestTemplate();
//    	
//    	//Object resultCall = restTemplate.execute(, HttpMethod.POST, clientHttpRequest -> {}, clientHttpResponse -> new Object());
//    	
//    	String url= "http://localhost:9005/actuator/refresh";
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//    	map.add("email", "first.last@example.com");
//
//    	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);    	
//    	ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
//    	
//    	//String resultCall = restTemplate.postForObject("http://localhost:9005/actuator/refresh", new HashMap<>(), String.class);
//    	return "resultCall : /actuator/refresh : [" + response.getBody() + "]";
//    }

}
