package com.midastouch.test1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1Controller {

    private final ApiService apiService = new ApiService();

    public String poop() {
        return "poop from Test1Controller!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from Test1Controller!";
    }

    @RequestMapping("/stinky")
    public String stinky() {
        return this.poop();
    }

    @RequestMapping("/external")
    public String getExternalData() {
        return apiService.callApi(); // call the service layer
    }
}

// API_key = VxtMFrWYUGKx73OOjeDXqVnabbwTQSpT