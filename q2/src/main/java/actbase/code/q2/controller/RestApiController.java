package actbase.code.q2.controller;

import actbase.code.q2.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @Autowired
    RestService restService;

    @GetMapping("hello")
    public String hello(String name){
        return restService.sayHello(name);
    }
}
