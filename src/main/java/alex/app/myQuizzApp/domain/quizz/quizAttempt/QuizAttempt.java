package alex.app.myQuizzApp.domain.quizz.quizAttempt;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import alex.app.myQuizzApp.domain.quizz.questionAnswer.QuestionAnswer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


//becomes unmodifiable after time elapses

@Entity
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime beginTime;
    private LocalTime timeElapsed;

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

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }


    public void setTimeElapsed(LocalTime timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public LocalTime getTimeElapsed() {
        return timeElapsed;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public int evaluate(){
        int points=0;
        for(QuestionAnswer ans:questionAnswers){
            if(ans.evaluate())
                points++;
        }
        return  points;
    }
    public int countQuestionsUnanswered(){
        int points=0;

        for(QuestionAnswer ans:questionAnswers){
            if(ans.getAnswers()==null)
                points++;
        }

        return  points;

    }
}
