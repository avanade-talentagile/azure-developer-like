package com.example.functions;

import com.example.functions.model.UserFeedback;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

public class HelloHandler extends FunctionInvoker<UserFeedback, String> {

    @FunctionName("hello")
    public HttpResponseMessage execute(
        @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) 
        HttpRequestMessage<Optional<UserFeedback>> request,
        ExecutionContext context) {
        // UserFeedback feedback = request.getBody()
        //                    .filter((u -> u.getTitle() != null))
        //                    .orElseGet(() -> new UserFeedback());
        // context.getLogger().info("Greeting user name: " + feedback.getTitle());
        return request
            .createResponseBuilder(HttpStatus.OK)
            // .body(handleRequest(feedback, context))
            .body("OK")
            .header("Content-Type", "application/json")
            .build();
    }
}
