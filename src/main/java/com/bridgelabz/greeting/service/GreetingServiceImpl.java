package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

    @Service
    public class GreetingServiceImpl implements GreetingServiceI{

        @Autowired
        GreetingRepository greetingRepository;

        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @Override
        public Greeting getGreetingInfo(User user) {
            String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
            return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
        }

        @Override
        public Greeting getGreetingById(Long id) {
            return greetingRepository.findById(id).get();
        }
    }
