package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;


@Entity
public class Option  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String option;
    private boolean isRight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }
    public boolean getIsRight(){return  isRight;}

}


