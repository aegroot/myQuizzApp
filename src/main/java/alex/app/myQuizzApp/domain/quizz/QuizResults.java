package alex.app.myQuizzApp.domain.quizz;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import jakarta.persistence.OneToMany;

public class QuizResults {

    @OneToMany
    Quiz quiz;

    float resultPerCent;
}
