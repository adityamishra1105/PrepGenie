package com.prepgenie.controller;

import com.prepgenie.model.Question;
import com.prepgenie.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // ✅ Add Question (with @Valid)
    @PostMapping
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    // ✅ Update Question by ID (with @Valid)
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question question) {
        Question updated = questionService.updateQuestion(id, question);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Get all questions (no pagination)
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    // ✅ Get paginated questions
    @GetMapping("/paginated")
    public ResponseEntity<Page<Question>> getPaginatedQuestions(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(questionService.getAllQuestions(pageable));
    }

    // ✅ Get Question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    // ✅ Delete Question
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Get by Topic
    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Question>> getByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(questionService.getQuestionsByTopic(topic));
    }

    // ✅ Get by Difficulty
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Question>> getByDifficulty(@PathVariable String difficulty) {
        return ResponseEntity.ok(questionService.getQuestionsByDifficulty(difficulty));
    }

    // ✅ Get by Role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Question>> getByRole(@PathVariable String role) {
        return ResponseEntity.ok(questionService.getQuestionsByRole(role));
    }

    // ✅ Get by Difficulty (query param based)
    @GetMapping(value = "/filter", params = "difficulty")
    public List<Question> getQuestionsByDifficulty(@RequestParam String difficulty) {
        return questionService.getQuestionsByDifficulty(difficulty);
    }

    // ✅ Get by Topic AND Difficulty (query param based)
    @GetMapping(value = "/filter", params = {"topic", "difficulty"})
    public ResponseEntity<List<Question>> getByTopicAndDifficulty(
            @RequestParam String topic,
            @RequestParam String difficulty) {
        return ResponseEntity.ok(questionService.getByTopicAndDifficulty(topic, difficulty));
    }
}
