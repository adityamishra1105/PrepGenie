package com.prepgenie.service;

import com.prepgenie.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    List<Question> getAllQuestions(); // optional for non-paginated
    Page<Question> getAllQuestions(Pageable pageable); // <-- ADD THIS
    Question getQuestionById(Long id);
    void deleteQuestion(Long id);
    Question updateQuestion(Long id, Question question);

    List<Question> getQuestionsByTopic(String topic);
    List<Question> getQuestionsByDifficulty(String difficulty);
    List<Question> getQuestionsByRole(String role);
    List<Question> getByTopicAndDifficulty(String topic, String difficulty);

}
