package com.prepgenie.repository;

// Repository Layer
import com.prepgenie.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This is an interface that talks to the database using Spring Data JPA:
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTopic(String topic);

    List<Question> findByDifficulty(String difficulty);

    List<Question> findByRole(String role);

    List<Question> findByTopicAndDifficulty(String topic, String difficulty);
}
