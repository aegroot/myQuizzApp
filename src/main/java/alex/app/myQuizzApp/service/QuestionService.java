package alex.app.myQuizzApp.service;

import alex.app.myQuizzApp.domain.question.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionService {
    // TODO: 19/10/2023

    @Autowired
    private QuestionRepository questionRepository;
    public void create(String[] options, String question){}
    public void delete(long id){
    }
    public Optional<Question>findById(long id){
        return Optional.empty();
    }
    public List<Question> findByUser(long id){
        return null;
    }
}

