package com.example.question.conroller;

import com.example.question.entity.Question;
import com.example.question.servise.ExaminerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController (ExaminerService examinerService) {
        this.examinerService=examinerService;
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exeptionHandler(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @GetMapping("/exam/randomlist")
    public Collection<Question> getRandomList(@RequestParam ("amount") int amount) throws Exception {
        return examinerService.getQuestions(amount);
    }


}
