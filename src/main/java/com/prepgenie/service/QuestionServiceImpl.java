package com.prepgenie.service;

import com.prepgenie.model.Question;
import com.prepgenie.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        // Update fields (make sure Question class has getters/setters or Lombok @Getter/@Setter)
        existingQuestion.setQuestionText(updatedQuestion.getQuestionText());
        existingQuestion.setAnswer(updatedQuestion.getAnswer());
        existingQuestion.setDifficulty(updatedQuestion.getDifficulty());
        existingQuestion.setTopic(updatedQuestion.getTopic());
        existingQuestion.setType(updatedQuestion.getType());
        existingQuestion.setRole(updatedQuestion.getRole());

        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return questionRepository.findByTopic(topic);
    }

    @Override
    public List<Question> getQuestionsByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Question> getQuestionsByRole(String role) {
        return questionRepository.findByRole(role);
    }

    @Override
    public List<Question> getByTopicAndDifficulty(String topic, String difficulty) {
        return questionRepository.findByTopicAndDifficulty(topic, difficulty);
    }

}
