package com.vladturtoi.chat;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@AllArgsConstructor
public class WebSocketEventListener {

    SocketAuthoriser socketAuthoriser;

    @SendTo("/topic/user.joined")
    public User userJoined(User user) {
        return user;
    }

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {
        System.out.println("Connected " + event);
        System.out.println("Connected " + event.getMessage().getPayload());
        System.out.println("Connected " + event.getUser());
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        System.out.println("Disconnected");
    }
}
