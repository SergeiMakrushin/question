package com.example.question.servise;

import com.example.question.entity.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();



    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.removeIf(e -> e.equals(question));

        return question;
    }

//    set.removeIf(s -> s.length() % 2 == 0)

//    Collection<String> filteredCollection = names
//            .stream()
//            .filter(e -> !e.startsWith("A"))
//            .collect(Collectors.toList());

//public static HashSet<Integer> removeAllLargetTen(HashSet<Integer> set){
//    Set<Integer> tmp = new HashSet<>();
//    for(int temp : set){
//        if(temp > 10){
//            tmp.add(temp);
//        }
//    }
//    set.removeAll(tmp);
//    return set;
//}


    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int numberQuestion = random.nextInt(questions.size());
        List<Question> listQuestion = new ArrayList<>(questions);
        return listQuestion.get(numberQuestion);

    }
//    List<Integer> list = new ArrayList<Integer>( hSetNumbers );
//    int curentIndex=0;
//        for (Question question : questions) {
//        if (curentIndex == 2) {
//            System.out.println("question = " + question);
//            break;
//        }
//        curentIndex++;
//    }
//    @Override
//    public Question getRandomQuestion(int number) {
//        Random random = new Random();
//        int numberQuestion = random.nextInt(number);
//        return null;
//    }
}
