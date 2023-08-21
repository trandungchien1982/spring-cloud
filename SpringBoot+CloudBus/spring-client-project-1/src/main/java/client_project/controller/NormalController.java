package client_project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NormalController {
	@Value("${value01}")
    private String value01;

	@Value("${value02}")
    private String value02;
	
    @GetMapping("/normal01")
    public String test01() {
        return "<br/>In Client 1 - NormalController :: <br/>Value 01 : " + value01;
    }

    @GetMapping("/normal02")
    public String test02() {
        return "<br/>In Client 1 - NormalController :: <br/>Value 02 : " + value02;
    }

}
