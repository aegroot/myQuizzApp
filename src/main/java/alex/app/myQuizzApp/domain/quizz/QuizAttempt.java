package alex.app.myQuizzApp.domain.quizz;

import java.time.LocalDateTime;

public class QuizAttempt {

    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Quiz quiz;

    QuestionAnswer[] questionAnswers;

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setQuestionAnswers(QuestionAnswer[] questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public QuestionAnswer[] getQuestionAnswers() {
        return questionAnswers;
    }

    public Quiz getQuiz() {
        return quiz;
    }
}
