package com.travel.dit.springwebpractice.controller;

import com.travel.dit.springwebpractice.dto.HelloMessage;
import com.travel.dit.springwebpractice.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {

    @PostMapping("/hello")
    public HelloMessage getHelloMessage(@RequestBody User user) {
        HelloMessage helloMessage = new HelloMessage();
        String name = user.getName();
        helloMessage.setMessage("Hello " + name + "! How are you doing?");
        helloMessage.setName(name);
        return helloMessage;

    }


}
