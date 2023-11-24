package com.example.question.servise;

import com.example.question.entity.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            try {
                throw new Exception("нет такого количества билетов");

            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        HashSet<Question> questionList = new HashSet<>();
        while (questionList.size() < amount) {

            questionList.add(questionService.getRandomQuestion());
        }

        return questionList;
    }

}

