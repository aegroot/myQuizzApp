package alex.app.myQuizzApp.dbService;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import alex.app.myQuizzApp.domain.question.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import  java.util.List;

public class QuizService {
    // TODO: 19/10/2023

    @Autowired
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }


    public void create(Quiz quiz){

        quizRepository.save(quiz);
    }

    public void delete(long quizId){

        Quiz quizDeleter=quizRepository.findById(quizId).orElseThrow();

        quizRepository.delete(quizDeleter);
    }
    public Quiz getById(long id){
        var quizOptional= quizRepository.findById(id);

        return quizOptional.orElse(null);

    }

    public List<Quiz>getAll(){
        return quizRepository.findAll();
    }
}
