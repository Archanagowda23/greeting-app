package com.bridgelabz.greeting.controller;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.service.GreetingServiceI;
import com.bridgelabz.greeting.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/greeting")
@RestController
public class GreetingController {

    @Autowired
    GreetingServiceI greetingServiceI;

    @GetMapping("/Hello")
    public String getData(){
        return "Hello World";
    }

    @GetMapping(value = {"","/","/home"})
    public String sayHello(){
        return "Hello From Bridgelabz";
    }

    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return "Hello "+ name +" from bridgelabz";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello "+ name +" from bridgelabz";
    }

    @PostMapping ("/post")
    public String sayHello(@RequestBody User user){
        return "Hello "+user.getFirstName() + " " +user.getLastName() +" !";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                                 @RequestParam(value = "lastName") String lastName){
        return "Hello "+firstName+ " " + lastName +" !";
    }

    @GetMapping("/getGreetingData")
    public Greeting greeting(@RequestParam(value = "fName",defaultValue = "Archana")String fname,
                             @RequestParam(value = "lName",defaultValue = "Gowda")String lname){
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        return greetingServiceI.getGreetingInfo(user);
    }

    @GetMapping("/getGreetingById/{id}")
    public Greeting getGreetingCardById(@PathVariable Long id){
        return greetingServiceI.getGreetingById(id);
    }
}
