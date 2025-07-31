package com.prepgenie.service.impl;

import com.prepgenie.model.Question;
import com.prepgenie.repository.QuestionRepository;
import com.prepgenie.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        return questionRepository.findById(id).map(q -> {
            q.setQuestionText(updatedQuestion.getQuestionText());
            q.setAnswer(updatedQuestion.getAnswer());
            q.setDifficulty(updatedQuestion.getDifficulty());
            q.setTopic(updatedQuestion.getTopic());
            q.setType(updatedQuestion.getType());
            q.setRole(updatedQuestion.getRole());
            return questionRepository.save(q);
        }).orElse(null);
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
