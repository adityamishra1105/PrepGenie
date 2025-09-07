package com.prepgenie.controller;

import com.prepgenie.model.Question;
import com.prepgenie.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // Add Question
    @PostMapping
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    // Update Question
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(id, question));
    }

    // Get all questions (no pagination)
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions(Pageable.unpaged()).getContent());
    }

    // Get paginated questions
    @GetMapping("/paginated")
    public ResponseEntity<Page<Question>> getPaginatedQuestions(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(questionService.getAllQuestions(pageable));
    }

    // Get Question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Question
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    // Get by Topic
    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Question>> getByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(questionService.getQuestionsByTopic(topic));
    }

    // Get by Difficulty
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Question>> getByDifficulty(@PathVariable String difficulty) {
        return ResponseEntity.ok(questionService.getQuestionsByDifficulty(difficulty));
    }

    // Get by Role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Question>> getByRole(@PathVariable String role) {
        return ResponseEntity.ok(questionService.getQuestionsByRole(role));
    }

    // Get by Topic + Difficulty (Query Param)
    @GetMapping(value = "/filter", params = {"topic", "difficulty"})
    public ResponseEntity<List<Question>> getByTopicAndDifficulty(
            @RequestParam String topic,
            @RequestParam String difficulty) {
        return ResponseEntity.ok(questionService.getByTopicAndDifficulty(topic, difficulty));
    }

    // Search Questions
    @GetMapping("/search")
    public ResponseEntity<List<Question>> searchQuestions(@RequestParam String keyword) {
        // If you add search logic in service later
        return ResponseEntity.ok(List.of()); // placeholder
    }
}
