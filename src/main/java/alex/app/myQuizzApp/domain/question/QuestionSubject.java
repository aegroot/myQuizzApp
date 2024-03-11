package alex.app.myQuizzApp.domain.question;


import jakarta.persistence.*;

@Entity
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public class QuestionSubject {
    @Id
    @Column(nullable = false)
    private String name;
    private  String description;


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
