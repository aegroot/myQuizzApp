package alex.app.myQuizzApp.domain.summary;

import alex.app.myQuizzApp.domain.quizz.question.QuestionSubject;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SummaryChapter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    Set<QuestionSubject>subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
