package com.example.form.repository;
import org.springframework.stereotype.Repository;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.form.model.UserFeedback;

@Repository
public interface UserFeedbackRepository extends CosmosRepository<UserFeedback, String> {
}
