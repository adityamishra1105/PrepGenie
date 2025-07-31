package com.prepgenie.controller;

import com.prepgenie.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gpt")
public class GptController {

    @Autowired
    private GptService gptService;

    @GetMapping("/generate")
    public String getQuestion(@RequestParam String topic,
                              @RequestParam String difficulty,
                              @RequestParam String type,
                              @RequestParam String role) {
        return gptService.generateQuestion(topic, difficulty, type, role);
    }
}
