package com.example.form;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.example.form.model.UserFeedback;

import reactor.core.publisher.Flux;

@Repository
public interface UserFeedbackRepository extends ReactiveCosmosRepository<UserFeedback, String> {
    // Flux<UserFeedback> findByUser(String userId);
}
