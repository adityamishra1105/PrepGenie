package com.prepgenie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

// Entity = Table in DB
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question text can't be blank")
    @Size(min = 10, message = "Question text must be at least 10 characters")
    private String questionText;

    @NotBlank(message = "Difficulty is required")
    private String difficulty;   // EASY, MEDIUM, HARD

    @NotBlank(message = "Topic is required")
    private String topic;        // Java, DSA, etc.

    @NotBlank(message = "Role is required")
    private String role;         // SDE, Analyst, etc.

    @NotBlank(message = "Type is required")
    private String type;         // MCQ, Subjective, etc.

    @NotBlank(message = "Answer is required")
    private String answer;       // Optional in future if you use DTOs
}
