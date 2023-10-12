package alex.app.myQuizzApp.domain.quizz;

import java.time.LocalDateTime;

public class QuizAttempt {

    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    Quiz quiz;

    QuestionAnswer[] questionAnswers;
}
