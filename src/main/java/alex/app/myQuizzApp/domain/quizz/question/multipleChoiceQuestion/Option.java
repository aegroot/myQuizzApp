package alex.app.myQuizzApp.domain.quizz.question.multipleChoiceQuestion;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
class Option implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String option;
    boolean isGood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}


