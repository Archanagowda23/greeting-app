package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import org.springframework.stereotype.Service;

@Service
public interface GreetingServiceI {
    Greeting getGreetingInfo(User user);
    Greeting getGreetingById(Long id);
}
