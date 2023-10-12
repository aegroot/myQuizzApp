package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.util.Map;
import java.util.Set;


@Entity
@DiscriminatorValue("multiple_choice")
public class MultipleChoiceQuestion extends Question{
    private Set<Map.Entry<String,Boolean>> answers;
}
