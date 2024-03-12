package alex.app.myQuizzApp.dbService;

import alex.app.myQuizzApp.domain.question.Question;
import alex.app.myQuizzApp.domain.quizz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionService {
    // TODO: 19/10/2023

    @Autowired
    private QuestionRepository questionRepository;
    public void create(Question question){
        questionRepository.save(question);
    }
    public void delete(long id){
        Optional<Question> questionOptional=questionRepository.findById(id);

        Question question=questionOptional.orElseThrow();

        questionRepository.delete(question);
    }
    public void update(long id){}
    public Optional<Question>findById(long id){return questionRepository.findById(id);}
    public List<Question> findByUser(long id){return null;}
}

