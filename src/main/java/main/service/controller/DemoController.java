package main.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import main.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Reference
    private DemoService demoService;

    @RequestMapping("/demo")
    public String demo() {
        return demoService.sayHello("mo");
    }
}
