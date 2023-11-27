package alex.app.myQuizzApp.domain.quizz.quizAttempt;

import org.springframework.beans.factory.annotation.Autowired;

public class QuizAttemptService {
    // TODO: 19/10/2023

    @Autowired
    QuizAttemptRepository quizAttemptRepository;

    public void submit(QuizAttempt attempt){
    }
    public void cancelAttempt(QuizAttempt attempt){}
    public QuizAttemptRepository getById(){
        return null;
    }
}
