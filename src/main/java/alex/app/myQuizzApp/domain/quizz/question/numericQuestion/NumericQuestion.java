package alex.app.myQuizzApp.domain.quizz.question.numericQuestion;


import alex.app.myQuizzApp.domain.quizz.question.Question;
import jakarta.persistence.*;


@Entity
@DiscriminatorValue("numeric")
public class NumericQuestion extends Question {


    private double answer;
    private int answerPrecision;

}
