package com.example.question;

import com.example.question.entity.Question;
import com.example.question.servise.ExaminerService;
import com.example.question.servise.ExaminerServiceImpl;
import com.example.question.servise.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)

public class ExaminerTest {
    @Mock
    QuestionService questionService;

    ExaminerServiceImpl examinerService;

    Question question1 = new Question("вопрос 1", "ответ 1");
    Question question2 = new Question("вопрос 2", "ответ 2");
    Question question3 = new Question("вопрос 3", "ответ 3");


    HashSet<Question> questions = new HashSet<>();

    HashSet<Question> reternGetAll = new HashSet<>();


    @BeforeEach
    public void setUp() {
        examinerService = new ExaminerServiceImpl(questionService);

        questions.add(question1);
        questions.add(question2);

        reternGetAll.add(question1);
        reternGetAll.add(question2);
        reternGetAll.add(question3);


    }

    public Question randomQuestionServise() {
        Random random = new Random();
        int numberQuestion = random.nextInt(questions.size());
        List<Question> listQuestion = new ArrayList<>(questions);
        return listQuestion.get(numberQuestion);

    }

    @Test
    void getQuestion() {


        Mockito.when(questionService.getAll()).thenReturn(reternGetAll);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(randomQuestionServise());
        int expected = 2;
        int actual = examinerService.getQuestions(2).size();
        assertEquals(expected, actual);
    }




//        Mockito.when(questionService.getAll()).thenReturn(questions);
//        int expected=2;
//        int actual =examinerService.getAll().size();
//        assertEquals(expected,actual);


    @Test
    void checkExceptionQuestion() {

        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(5),
                "НЕПРАВИЛЬНОЕ ИСКЛЮЧЕНИЕ, ТРЕБУЕТСЯ IllegalArgumentException");

    }

}

