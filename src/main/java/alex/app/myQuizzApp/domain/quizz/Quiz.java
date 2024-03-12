package alex.app.myQuizzApp.domain.quizz;

import alex.app.myQuizzApp.domain.question.Question;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalTime allowedTime;

    @ManyToMany
    List<Question> questions;

    public Quiz() {
    }

    public Quiz(String description, LocalTime allowedTime, List<Question> questions) {
        this.description=description;
        this.allowedTime=allowedTime;
        this.questions=questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) &&
                Objects.equals(description, quiz.description) &&
                Objects.equals(allowedTime, quiz.allowedTime) &&
                Objects.equals(questions, quiz.questions);
    }

}
