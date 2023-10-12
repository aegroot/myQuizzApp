package alex.app.myQuizzApp.domain.quizz.quizAttempt;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import alex.app.myQuizzApp.domain.quizz.questionAnswer.QuestionAnswer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany
    Set<QuestionAnswer> questionAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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



    public Quiz getQuiz() {
        return quiz;
    }
}
