package org.yida.attendanceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/getName")
    public String getName(){
        return "Hello SpringBoot";
    }
}
