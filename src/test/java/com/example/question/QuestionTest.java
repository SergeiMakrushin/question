package com.example.question;

import com.example.question.entity.Question;
import com.example.question.servise.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    private final JavaQuestionService questionService = new JavaQuestionService();

    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;

    @BeforeEach
    public void setUp() {
        question1 = new Question("вопрос 1", "ответ 1");
        question2 = new Question("вопрос 2", "ответ 2");
        question3 = new Question("вопрос 3", "ответ 3");
        question4 = new Question("вопрос 4", "ответ 4");
        question5 = new Question("вопрос 5", "ответ 5");
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);
        questionService.add(question4);
        questionService.add(question5);

    }

    @Test
    void getAll() {
        int expected = 5;
        int actual = questionService.getAll().size();
        assertEquals(actual, expected);

        HashSet<Question> questionsTestSet = new HashSet<>();
        questionsTestSet.add(question1);
        questionsTestSet.add(question2);
        questionsTestSet.add(question3);
        questionsTestSet.add(question4);
        questionsTestSet.add(question5);
        assertIterableEquals(questionsTestSet, questionService.getAll());


    }

    @Test
    public void addQuestion() {
        Collection<Question> actual = questionService.getAll();
        Question expected = questionService.getAll().iterator().next();

        assertNotNull(actual);
        assertInstanceOf(Question.class, expected);


    }

    @Test
    public void remove() {
        int expected=4;
        questionService.remove(question1);
        int actual=questionService.getAll().size();
        assertEquals(expected,actual);


    }
    @Test
    public void addString() {
        HashSet<Question> expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);

        questionService.getAll().clear();

        String question1 = "вопрос 1";
        String answer1 = "ответ 1";
        String question2 = "вопрос 2";
        String answer2 = "ответ 2";
        String question3 = "вопрос 3";
        String answer3 = "ответ 3";

        questionService.add(question1, answer1);
        questionService.add(question2, answer2);
        questionService.add(question3, answer3);

        assertIterableEquals(expected, questionService.getAll());
    }




}
