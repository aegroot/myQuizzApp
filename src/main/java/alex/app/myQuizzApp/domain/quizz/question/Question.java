package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    protected String question;
    protected Set<QuestionSubject> questionSubject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
