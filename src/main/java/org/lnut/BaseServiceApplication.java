package org.lnut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseServiceApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "hello world!";
    }
}
