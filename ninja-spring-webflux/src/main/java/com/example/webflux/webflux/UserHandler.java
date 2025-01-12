package com.example.webflux.webflux;

import com.example.webflux.po.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/24
 */
@Component
public class UserHandler {
    public Mono<ServerResponse> getUser(ServerRequest request) {
        Optional<String> userId = request.queryParam("userId");
        boolean present = userId.isPresent();
        int id;
        if (!present) {
            id = new Random().nextInt(100);
        } else {
            id = Integer.parseInt(userId.get());
        }
        Mono<User> just = Mono.just(User.builder().id(id).name(UUID.randomUUID().toString()).build())
                .map(user -> {
                    if (user.getId().equals(100)) {
                        throw new RuntimeException("userId limited");
                    }
                    return user;
                });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(just, User.class);
    }
}
