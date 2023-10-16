package alex.app.myQuizzApp.domain.quizz;

import alex.app.myQuizzApp.domain.quizz.question.Question;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalTime allowedTime;

    //set subjects from questions
    //option to restrict questions on subject(s)?

    @ManyToMany
    Set<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
