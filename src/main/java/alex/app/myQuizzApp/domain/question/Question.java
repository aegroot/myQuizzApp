package alex.app.myQuizzApp.domain.question;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @OneToMany
    private List<Option> options;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String question;

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


    public List<Option> getOptions() {
        return options;
    }

    public String getQuestion() {
        return question;
    }

    public static boolean isValid(Question question){
        if(question.getOptions()
                .stream()
                .map(Option::getOption)
                .distinct()
                .count()!=question.getOptions().size())
            return false;

        return question.getOptions()
                .stream()
                .anyMatch(Option::getIsRight)&& !question.getOptions().isEmpty();

    }


}
