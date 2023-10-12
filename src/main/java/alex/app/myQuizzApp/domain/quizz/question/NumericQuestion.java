package alex.app.myQuizzApp.domain.quizz.question;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("numeric")
public class NumericQuestion extends Question{

    private double answer;
    private int precision;
}
