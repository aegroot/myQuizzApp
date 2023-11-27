package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Question {

    @OneToMany
    private List<Option> options;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String question;


    //@OneToMany
    //private Set<QuestionSubject> questionSubject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

   // public void setQuestionSubject(Set<QuestionSubject> questionSubject) {this.questionSubject = questionSubject;}
   // public Set<QuestionSubject> getQuestionSubject() {return questionSubject;}

    public List<Option> getOptions() {
        return options;
    }

    public String getQuestion() {
        return question;
    }
}
