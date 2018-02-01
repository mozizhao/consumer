package main.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import main.service.DemoService;
import main.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Reference
    private DemoService demoService;

    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("/demo")
    public String demo() {
        return demoService.sayHello("mo");
    }

    @RequestMapping("/validate")
    public String validate() {
        return userInfoService.validate("201430613079", "mozizhao82289364") == null ? "yes" : "no";
    }
}
