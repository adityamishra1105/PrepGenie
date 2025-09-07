package com.prepgenie.service;

import com.prepgenie.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Page<Question> getAllQuestions(Pageable pageable);

    Optional<Question> getQuestionById(Long id);

    Question addQuestion(Question question);

    Question updateQuestion(Long id, Question updatedQuestion);

    void deleteQuestion(Long id);

    List<Question> getQuestionsByTopic(String topic);

    List<Question> getQuestionsByDifficulty(String difficulty);

    List<Question> getQuestionsByRole(String role);

    List<Question> getByTopicAndDifficulty(String topic, String difficulty);

}
