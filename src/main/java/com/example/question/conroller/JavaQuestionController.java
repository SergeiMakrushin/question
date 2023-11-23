package com.example.question.conroller;

import com.example.question.entity.Question;
import com.example.question.servise.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
//
//        Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
//
//        Получить все вопросы: “/exam/java”

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    //    Получить все вопросы
    @GetMapping("/java")
    public Collection<Question> getAll() {
        return this.javaQuestionService.getAll();
    }
//    Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    @DeleteMapping ("/java/remove")
    public Question remove (@RequestParam ("question")String question, @RequestParam("answer")String answer) {
        Question question1=new Question(question,answer);
    return  this.javaQuestionService.remove(question1);
    }

    //    Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    @PutMapping("/java/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.javaQuestionService.add(question, answer);
    }


}
