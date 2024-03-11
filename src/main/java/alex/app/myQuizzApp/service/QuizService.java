package alex.app.myQuizzApp.service;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import alex.app.myQuizzApp.domain.question.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.Set;
import  java.util.List;

public class QuizService {
    // TODO: 19/10/2023

    @Autowired
    QuizRepository quizRepository;

    //add userRepository

    public void create(String description,
                       LocalTime allowedTime, Set<Question> questions){

        quizRepository.save(new Quiz(description,allowedTime,questions));
    }

    public Quiz getById(long id){
        var quizOptional= quizRepository.findById(id);

        return quizOptional.orElse(null);

    }

    public List<Quiz>getAll(){
        return quizRepository.findAll();
    }
}
