package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Question {


    @OneToMany
    private Set<Option> answers;
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


}
