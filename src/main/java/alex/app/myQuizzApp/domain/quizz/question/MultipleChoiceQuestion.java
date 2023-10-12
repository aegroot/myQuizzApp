package alex.app.myQuizzApp.domain.quizz.question;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


@Entity
@DiscriminatorValue("multiple_choice")
public class MultipleChoiceQuestion extends Question{

    @OneToMany
    private Set<Option> answers;
}

