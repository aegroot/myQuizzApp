package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Question {


    @OneToMany
    private List<Option> answers;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String question;

    @OneToMany
    protected Set<QuestionSubject> questionSubject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswers(List<Option> answers) {
        this.answers = answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionSubject(Set<QuestionSubject> questionSubject) {
        this.questionSubject = questionSubject;
    }

    public Set<QuestionSubject> getQuestionSubject() {
        return questionSubject;
    }

    public List<Option> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }
}
