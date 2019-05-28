package com.vladturtoi.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    UserRepository userRepository;

    @MessageMapping("/user.joined")
    @SendTo("/topic/user.joined")
    public User send(User user) {
        userRepository.save(user);

        return user;
    }
}
