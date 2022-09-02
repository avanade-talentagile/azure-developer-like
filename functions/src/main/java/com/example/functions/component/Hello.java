package com.example.functions.component;

import org.springframework.stereotype.Component;
import com.example.functions.model.UserFeedback;
import reactor.core.publisher.Mono;
import java.util.function.Function;

@Component
public class Hello implements Function<Mono<UserFeedback>, String> {

    public String apply(Mono<UserFeedback> mono) {
        return  "Test";//mono.map(user -> new Greeting("Hello, " + user.getName() + "!\n"));
    }
}
